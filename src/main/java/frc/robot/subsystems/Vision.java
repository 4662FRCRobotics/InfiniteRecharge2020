/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.VisionConstants;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Relay.Value;

public class Vision extends SubsystemBase {
  /**
   * Creates a new Vision.
   */
  private NetworkTable m_visionTable;
  private Servo m_camera0Servo;
  private boolean m_bIsLightOn;
  private boolean m_bIsVisionOn;

  private Relay m_cameraLightRelay;

  private NetworkTableEntry m_vTestEntry;

  public Vision() {
    m_visionTable = NetworkTableInstance.getDefault().getTable("Vision");
    m_camera0Servo = new Servo(0);
    m_bIsLightOn = false;
    m_bIsVisionOn = false;

    m_cameraLightRelay = new Relay(VisionConstants.kLIGHT_RELAY_PORT);

    m_vTestEntry = m_visionTable.getEntry("Test");
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("rPi Test", (double) m_vTestEntry.getNumber(0));
    SmartDashboard.putNumber("Servo Angle", m_camera0Servo.getAngle());
  }

  private void setAngle(int angle){
    m_camera0Servo.setAngle(angle);
  }

  public void setServoShooter(){
    setAngle(VisionConstants.kSERVO_SHOOTER_ANGLE);
  }

  public void setServoDown(){
    setAngle(VisionConstants.kSERVO_DOWN_ANGLE);
  }

  public void setServoUp(){
    setAngle(VisionConstants.kSERVO_UP_ANGLE);
  }

  public void setLightRelayOn(){
    m_cameraLightRelay.set(Value.kForward);
    SmartDashboard.putBoolean("VisionLight", true);
  }

  public void setLightRelayOff(){
    m_cameraLightRelay.set(Value.kOff);
    SmartDashboard.putBoolean("VisionLight", false);
  }

}
