/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.HopperConstants;
import edu.wpi.first.wpilibj.DigitalInput;

public class Hopper extends SubsystemBase {
  /**
   * Creates a new Hopper.
   */

  private WPI_TalonSRX m_hopperMotor = new WPI_TalonSRX(HopperConstants.kHOPPER_MOTOR_PORT);
  private boolean m_bIsHopperMotorOn;
  private DigitalInput m_shooterSensor = new DigitalInput(HopperConstants.kSHOOTER_SENSOR_PORT);
  private DigitalInput m_intakeSensor = new DigitalInput(HopperConstants.kINTAKE_SENSOR_PORT);

  private boolean m_bShooterSensorReading;  // true - sees emitter
  private boolean m_bIntakeSensorReading;  // false - emitter is obscured

  public Hopper() {
    m_bShooterSensorReading = true;
    m_bIntakeSensorReading = true;
  }

  @Override
  public void periodic() {
    m_bIntakeSensorReading = m_intakeSensor.get();
    m_bShooterSensorReading = m_shooterSensor.get();
    SmartDashboard.putBoolean("Shooter Sensor reading", m_bShooterSensorReading);
    SmartDashboard.putBoolean("Intake Sensor reading", m_bIntakeSensorReading);
  }

  public void setHopperMotor(double speed) {
    m_hopperMotor.set(speed);
  }

  public void setHopperMotorOn() {
    setHopperMotor(HopperConstants.kHOPPER_SPEED);
    m_bIsHopperMotorOn = true;
    SmartDashboard.putBoolean("Is Hopper Motor On", m_bIsHopperMotorOn);
  }

  public void setHopperMotorOff() {
    setHopperMotor(HopperConstants.kHOPPER_ZERO_SPEED);
    m_bIsHopperMotorOn = false;
    SmartDashboard.putBoolean("Is Hopper Motor On", m_bIsHopperMotorOn);
  }

  private boolean isBallAtShooter(){
    return !m_bShooterSensorReading;
  }

  private boolean isBallAtIntake(){
    return !m_bIntakeSensorReading;
  }

  public boolean shouldHopperTurnOn(){
    return (!isBallAtShooter()) && isBallAtIntake();
  }

  public boolean shouldIntakeTurnOn(){
    return !(isBallAtShooter() && isBallAtIntake());
  }
}
