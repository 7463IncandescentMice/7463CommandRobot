/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.RobotMap;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */

 
public class Intake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  VictorSPX m_Intake1 = new VictorSPX(RobotMap.intakeMotor1);
  VictorSPX m_Intake2 = new VictorSPX(RobotMap.intakeMotor2);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    
    m_Intake1.set(ControlMode.PercentOutput, 0);
    m_Intake2.set(ControlMode.PercentOutput, 0);
  }

  public void intakeSpeed(double speed) {
    m_Intake1.set(ControlMode.PercentOutput, speed);
    m_Intake2.set(ControlMode.PercentOutput, speed * -1);
  }
}
