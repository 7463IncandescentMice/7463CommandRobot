/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.OI;

public class Drive extends Command {

  OI m_oi = new OI();
  Double previousSpeedLeft = 0.0;
  Double currentSpeedLeft = 0.0;
  Double previousSpeedRight = 0.0;
  Double currentSpeedRight = 0.0;

  Double accelerationCap = .01;

  public Drive() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // if (m_oi.stick1.getRawAxis(1) < (previousSpeedLeft - accelerationCap)) {
    //   currentSpeedLeft = previousSpeedLeft - accelerationCap;
    // } else if (m_oi.stick1.getRawAxis(1) > (previousSpeedLeft + accelerationCap)) {
    //   currentSpeedLeft = previousSpeedLeft + accelerationCap;
    // } else {
    //   currentSpeedLeft = m_oi.stick1.getRawAxis(1);
    // }

    // if (m_oi.stick1.getRawAxis(5) < (previousSpeedRight - accelerationCap)) {
    //   currentSpeedRight = previousSpeedRight - accelerationCap;
    // } else if (m_oi.stick1.getRawAxis(5) > (previousSpeedRight + accelerationCap)) {
    //   currentSpeedRight = previousSpeedRight + accelerationCap;
    // } else {
    //   currentSpeedRight = m_oi.stick1.getRawAxis(5);
    // }

    

    // Robot.m_drivetrain.drive(currentSpeedLeft, currentSpeedRight);
    Robot.m_drivetrain.drive(m_oi.stick1.getRawAxis(1), m_oi.stick1.getRawAxis(5));
    // Robot.m_drivetrain.arcadeDrive(m_oi.stick1.getRawAxis(1), m_oi.stick1.getRawAxis(4));
    previousSpeedLeft = currentSpeedLeft;
    previousSpeedRight = currentSpeedRight;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
