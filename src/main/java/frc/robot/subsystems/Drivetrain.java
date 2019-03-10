/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
//import frc.robot.RobotMap;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
    
    VictorSPX m_frontLeft = new VictorSPX(RobotMap.leftFrontMotor);
    VictorSPX m_frontRight = new VictorSPX(RobotMap.rightFrontMotor);
    VictorSPX m_backLeft = new VictorSPX(RobotMap.leftBackMotor);
    VictorSPX m_backRight = new VictorSPX(RobotMap.rightBackmotor);

    // WPI_VictorSPX m_frontLeft = new WPI_VictorSPX(RobotMap.leftFrontMotor);
    // WPI_VictorSPX m_frontRight = new WPI_VictorSPX(RobotMap.rightFrontMotor);
    // WPI_VictorSPX m_backLeft = new WPI_VictorSPX(RobotMap.leftBackMotor);
    // WPI_VictorSPX m_backRight = new WPI_VictorSPX(RobotMap.rightBackmotor);

    // private final SpeedController m_leftMotor
    //     = new SpeedControllerGroup(m_frontLeft, m_backLeft);
    // private final SpeedController m_rightMotor
    //     = new SpeedControllerGroup(new PWMVictorSPX(2), new PWMVictorSPX(3));

    // private final DifferentialDrive m_drive
    //     = new DifferentialDrive(m_leftMotor, m_rightMotor);
    
  @Override
  public void initDefaultCommand() {

      m_frontLeft.set(ControlMode.PercentOutput, 0);
      m_frontRight.set(ControlMode.PercentOutput, 0);
      m_backLeft.set(ControlMode.PercentOutput, 0);
      m_backRight.set(ControlMode.PercentOutput, 0);

    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void drive(double left, double right) {
      m_frontLeft.set(ControlMode.PercentOutput, left * -1);
      m_frontRight.set(ControlMode.PercentOutput, right);
      m_backLeft.set(ControlMode.PercentOutput, left * -1);
      m_backRight.set(ControlMode.PercentOutput, right);
  }

  // public void arcadeDrive(double v, double h) {
  //   m_drive.arcadeDrive(v, h);
  // }
}
