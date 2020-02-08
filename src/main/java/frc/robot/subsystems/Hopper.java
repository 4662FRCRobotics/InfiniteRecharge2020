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

public class Hopper extends SubsystemBase {
  /**
   * Creates a new Hopper.
   */

  private WPI_TalonSRX m_hopperMotor = new WPI_TalonSRX(HopperConstants.kHOPPER_MOTOR_PORT);
  private double m_sensorReading;
  private boolean m_bIsHopperMotorOn;

  // private [insert sensor type here] m_hopperSensor = new [insert sensor type here]([insert sensor port here])


  public Hopper() {
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    m_sensorReading = getReading();
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

  private double getReading(){
    return 9.0; // arbitrary value for now
  }

  public boolean isHopperFull(){
    boolean returnValue = false;
    //double reading = getReading();
    //returnValue = reading < HopperConstants.kDISTANCE_THRESHOLD;
    return returnValue;
  }
}
