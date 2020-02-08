/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

  private String m_ArmStatus;
  private String m_ArmStopPosition;
  private String m_SpinnerStatus;
  private boolean m_isArmDown;
  /**
   * Creates a new Intake.
   */
  public Intake() {
    m_isArmDown = false;
    m_ArmStatus = "initial";
    m_SpinnerStatus = "initial";
  }

  private void ArmUp() {
    m_ArmStatus = "Moving Up";
  }

  public void ArmDown() {
    m_ArmStatus = "Moving Down";
  }
  
  
  public void ArmStop() {
    m_ArmStatus = "Arm Stopped Moving";
  }

  public boolean isArmDown() {
    return true;
  }

  public void SpinnerOn() {
    m_SpinnerStatus = "Spinning";
  }

  public void SpinnerOff() {
    m_SpinnerStatus = "Not Spinning";
  }

  
 public void CombineUp() {
    SpinnerOff();
    ArmUp();
 }
  /*
  public void CombineDown() {
    ArmDown();
    SpinnerOn();
  }*/
  /*
  public void CombineRun() {
    if (m_isArmDown == false){
      ArmDown();
      m_isArmDown = true;
    }
    SpinnerOn();
  }
  */
  public void CombineStop() {
    //ArmStop();
    SpinnerOff();
  }

  @Override
  public void periodic() {
    SmartDashboard.putString("Arm Status", m_ArmStatus);
    SmartDashboard.putString("Spinner Status", m_SpinnerStatus);
  }
}
