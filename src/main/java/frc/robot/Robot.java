// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.Mechanism2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismLigament2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismRoot2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color8Bit;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the
 * name of this class or
 * the package after creating this project, you must also update the
 * build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  MechanismLigament2d bras = null;
  MechanismLigament2d avantbras = null;
  MechanismLigament2d main = null;

  Joystick key2 = null;

  /**
   * This function is run when the robot is first started up and should be used
   * for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    System.out.println("oui");
    Mechanism2d mech = new Mechanism2d(10, 10);
    // Creation du root
    MechanismRoot2d root = mech.getRoot("BrasRobotiqueDeLucca", 1, 5);
    // construire le bras
    bras = root.append(new MechanismLigament2d("bras", 2, 0, 20, new Color8Bit(0, 150, 155)));
    // Construire l'avant-bras
    avantbras = bras.append(new MechanismLigament2d("avantBras", 2, 30, 10, new Color8Bit(200, 50, 200)));
    // Construire la main
    main = avantbras.append(new MechanismLigament2d("Main", 1, 60));

    SmartDashboard.putData("Mech2d", mech);

    key2 = new Joystick(0);
  }

  @Override
  public void robotPeriodic() {
    double axis2 = key2.getRawAxis(0);
    SmartDashboard.putNumber("joystick2 axis2", axis2);

    double avantbrasAngle = 90 * axis2;
    SmartDashboard.putNumber("avantbrasAngle", avantbrasAngle);

    avantbras.setAngle(avantbrasAngle);
  }

}
