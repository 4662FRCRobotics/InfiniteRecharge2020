/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.ParamEnum;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimberConstants;

public class Climb extends SubsystemBase {

  private boolean m_bIsClimbBrakeSet;
  private WPI_TalonSRX m_ClimbMotorFwd;
  private WPI_TalonSRX m_ClimbMotorInv;
  /**
   * Creates a new Climb.
   */
  public Climb() {
    m_bIsClimbBrakeSet = true;
    m_ClimbMotorFwd = new WPI_TalonSRX(ClimberConstants.kCLIMBER_FWD_PORT);
    m_ClimbMotorInv = new WPI_TalonSRX(ClimberConstants.kCLIMBER_INV_PORT);
    m_ClimbMotorFwd.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);
    m_ClimbMotorFwd.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);
    m_ClimbMotorInv.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);
    m_ClimbMotorInv.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);
  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Climb Brake", m_bIsClimbBrakeSet);
    //Display the state of the Climb brake(s) on SmartDashboard.
  }
  private void setClimbMotor(double climbSpeed){
    SmartDashboard.putNumber("Climb Speed",climbSpeed);
    m_ClimbMotorFwd.set(climbSpeed);
    m_ClimbMotorInv.set(-climbSpeed);
    //Display the speed of the Climb motors on SmartDashboard.
  }
  public void climbUp(){
    setClimbMotor(ClimberConstants.kCLIMB_UP_SPEED);
  }
  public void climbDown(){
    setClimbMotor(ClimberConstants.kCLIMB_DOWN_SPEED);
  }
  public void climbStop(){
    setClimbMotor(ClimberConstants.kCLIMB_STOP);
  }

  public void climbBrakeSet(){
    m_bIsClimbBrakeSet = true;
 
  }
  public void climbBrakeRelease(){
    m_bIsClimbBrakeSet = false;
  }
}
