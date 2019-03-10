/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.EjectorCommand;
import frc.robot.RobotMap;



/**
 * Add your docs here.
 */
public class Ejector extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.---------------------
  public Compressor compressor;
  public DoubleSolenoid solenoid;
  // Solenoid ejectorPistons = new Solenoid(0);

  public Ejector() {
    compressor = new Compressor(RobotMap.compressor);
    solenoid = new DoubleSolenoid(RobotMap.ejectSolenoidF, RobotMap.ejectSolenoidR);

    compressor.setClosedLoopControl(true);
    compressor.start();
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new EjectorCommand());
  }
  public void setPiston() {
  
  }
  public void solenoidForward() {
    solenoid.set(Value.kForward);
  }
  public void solenoidReverse() {
    solenoid.set(Value.kReverse);
  }
}

