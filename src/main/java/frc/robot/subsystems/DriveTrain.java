/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriverArcade;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
Spark leftFrontSpark=null;
Spark leftBackSpark=null;
Spark rightFrontSpark=null;
Spark rightBackSpark=null;
DifferentialDrive differentialDrive=null;

public Object m_driveTrain;

  public DriveTrain(){
  leftFrontSpark= new Spark(0);
  leftBackSpark= new Spark(1);
  rightFrontSpark= new Spark(2);
  rightBackSpark= new Spark(3);

  leftFrontSpark= new Spark(RobotMap.DriveTrain_left_front_spark);
  leftBackSpark= new Spark(RobotMap.DriveTrain_left_back_spark);
  rightFrontSpark= new Spark(RobotMap.DriveTrain_right_front_spark);
  rightBackSpark=new Spark(RobotMap.DriveTrain_right_back_spark);

  SpeedControllerGroup leftMotor= new SpeedControllerGroup(leftFrontSpark,leftBackSpark);
  SpeedControllerGroup rightMotor= new SpeedControllerGroup(rightFrontSpark,rightBackSpark);

  differentialDrive= new DifferentialDrive(leftMotor, rightMotor);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriverArcade());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

public void arcadeDrive(double moveSpeed, double rotateSpeed) {
  differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
}
}
