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

public class Vision extends SubsystemBase {
  /**
   * Creates a new Vision.
   */
  private NetworkTable m_visionTable;
  private boolean m_bIsLightOn;
  private boolean m_bIsVisionOn;

  private NetworkTableEntry m_vTestEntry;

  public Vision() {
    m_visionTable = NetworkTableInstance.getDefault().getTable("Vision");
    m_bIsLightOn = false;
    m_bIsVisionOn = false;

    m_vTestEntry = m_visionTable.getEntry("Test");
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("rPi Test", (double) m_vTestEntry.getNumber(0));
  }
}
