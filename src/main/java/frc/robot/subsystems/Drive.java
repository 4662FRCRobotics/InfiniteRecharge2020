/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.commands.ArcadeDrive;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.frc.revrobotics.CANEncoder;
import com.frc.revrobotics.CANSparkMax;
import com.frc.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Drive extends SubsystemBase {
  /**
   * Creates a new Drive.
   */
  private CANSparkMax m_leftController1;
  private CANSparkMax m_leftController2;
  private CANSparkMax m_rightController1;
  private CANSparkMax m_rightController2;

  private SpeedControllerGroup m_leftControlGroup;
  private SpeedControllerGroup m_rightControlGroup;

  private DifferentialDrive m_robotDrive;

  public Drive() {
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
