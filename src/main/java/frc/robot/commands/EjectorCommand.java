/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.Ejector;

public class EjectorCommand extends Command {
   boolean previousState;

  public EjectorCommand() {
    requires(Robot.m_ejector);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    previousState = false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    System.out.println((Robot.m_oi.stick1.getRawButton(1)));
    if (Robot.m_oi.stick1.getRawButtonPressed(1)) {
      previousState = !previousState;
      if (previousState) {
        Robot.m_ejector.solenoidForward();
        System.out.println(previousState + "Forward is working");
      }
      if (!previousState) {
        Robot.m_ejector.solenoidReverse();
        System.out.println(previousState + "Reverse is working");
      }
      // SmartDashboard.putBoolean("Ejector", true);

    // } else {
    //   Robot.m_ejector.Eject(false);
    //   SmartDashboard.putBoolean("Ejector", true);

    }

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
