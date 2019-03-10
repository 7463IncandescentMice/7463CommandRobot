/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import frc.robot.Robot;
import frc.robot.commands.Drive;


/**
 * Add your docs here.
 */
public class PIDDrivetrain extends PIDSubsystem {
  /**
   * Add your docs here.
   */

  private static final double kP_real = 4;
  private static final double kI_real = 0.07;
  NetworkTable table;

  public PIDDrivetrain() {
    // Intert a subsystem name and PID values here
    super(kP_real, kI_real, 0);
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    setSetpoint(0);
    // to
    // enable() - Enables the PID controller.
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  protected double returnPIDInput() {
    
    table = NetworkTable.getTable("datatable");
    return table.getNumber("x", 0);
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    Robot.m_drivetrain.drive(-output, output);
  }
}
