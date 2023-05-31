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
  Joystick key1 = null;
//A
  MechanismLigament2d t1 = null;
  MechanismLigament2d t2 = null;
  MechanismLigament2d t3 = null;
  MechanismLigament2d t4 = null;
  Joystick keyA = null;
//D
  MechanismLigament2d Y1 = null;
  MechanismLigament2d Y2 = null;
  MechanismLigament2d Y3 = null;
  Joystick keyD = null;
  
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
    MechanismRoot2d root = mech.getRoot("BrasRobotiqueDeLucca", 5, 1);
    // construire le bras
    bras = root.append(new MechanismLigament2d("bras", 2, 0, 20, new Color8Bit(0, 150, 155)));
    // Construire l'avant-bras
    avantbras = bras.append(new MechanismLigament2d("avantBras", 2, 30, 10, new Color8Bit(200, 50, 200)));
    // Construire la main
    main = avantbras.append(new MechanismLigament2d("Main", 1, 60, 10, new Color8Bit(200, 150, 20)));

    SmartDashboard.putData("Mech2d", mech);

    key2 = new Joystick(0);
    key1 = new Joystick(0);



    Mechanism2d tentacule = new Mechanism2d(20, 20);

    //A
    MechanismRoot2d root2 = tentacule.getRoot("TentaculesDeLucca", 5, 0);
    t1 = root2.append(new MechanismLigament2d("t1", 6, 90, 40, new Color8Bit(0, 150, 155)));
    t2 = t1.append(new MechanismLigament2d("t2", 4, 50, 27, new Color8Bit(10, 200, 100)));
    t3 = t2.append(new MechanismLigament2d("t3", 5, -100, 15, new Color8Bit(255, 128, 0)));
    t4 = t3.append(new MechanismLigament2d("t4", 2, 30, 20, new Color8Bit(51, 52, 225)));
    
    //D
    MechanismRoot2d aeeee = tentacule.getRoot("aeeee", 15, 20);
    Y1 = aeeee.append(new MechanismLigament2d("Y1", 6, -90, 40, new Color8Bit(155, 155, 0)));
    Y2 = Y1.append(new MechanismLigament2d("Y2", 4, 50, 27, new Color8Bit( 200, 100, 10)));
    Y3 =Y2.append(new MechanismLigament2d("Y3", 5, -100, 15, new Color8Bit(0, 128, 255)));
  
    
    
    // SmartDashboard.putData("Tentacules banboles", tentacule);
    SmartDashboard.putData("Mon Tentacules banboles", tentacule);

    keyA = new Joystick(1);
    keyD = new Joystick(0);
  }

  /* (non-Javadoc)
   * @see edu.wpi.first.wpilibj.IterativeRobotBase#robotPeriodic()
   */
  @Override
  public void robotPeriodic() {
    double axis2 = key2.getRawAxis(0);
    SmartDashboard.putNumber("joystick2 axis2", axis2);

    double avantbrasAngle = 45 * axis2;
    SmartDashboard.putNumber("avantbrasAngle", avantbrasAngle);

    avantbras.setAngle(avantbrasAngle);

    double axis1 = key1.getRawAxis(1);
    SmartDashboard.putNumber("joystick1 axis1", axis1);


    double mainAngle = 100 * axis1;
    SmartDashboard.putNumber("mainAngle", mainAngle);

    main.setAngle(mainAngle);

// A
    double axisA = keyA.getRawAxis(0);
    SmartDashboard.putNumber("joystick-a axisA", axisA);

    double tentaculeAngle = 90 + 2 * axisA;
    double tentacule1Angle = 50 + 25 * axisA;
    double tentacule2Angle = -100 + -50 * axisA;
    double tentacule3Angle = 30 + 100 * axisA;
    SmartDashboard.putNumber("tentaculeAngle", tentaculeAngle);
    SmartDashboard.putNumber("tentacule1Angle", tentacule1Angle);
    SmartDashboard.putNumber("tentacule2Angle", tentacule2Angle);
    SmartDashboard.putNumber("tentacule3Angle", tentacule3Angle);

    t1.setAngle(tentaculeAngle);
    t2.setAngle(tentacule1Angle); 
    t3.setAngle(tentacule2Angle);
    t4.setAngle(tentacule3Angle);
// D
    double axisD = keyD.getRawAxis(1);
    SmartDashboard.putNumber("Joystick-d axisD", axisD);

    var tentaculyLonguer = 6 + 2;
    // var tentaculyAngle = 50 + 20;
    // // var tentaculyColor = null;

    SmartDashboard.putNumber("tentaculyLongeur", tentaculyLonguer);
    // SmartDashboard.putNumber("tentaculyAngle", tentaculyAngle);

    Y1.setLength(tentaculyLonguer);


    }

}
