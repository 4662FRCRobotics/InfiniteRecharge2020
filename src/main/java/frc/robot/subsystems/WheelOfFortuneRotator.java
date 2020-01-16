/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.I2C; 

public class WheelOfFortuneRotator extends SubsystemBase {
  /**
   * Creates a new WheelOfFortuneRotator.
   */

  private final I2C.Port i2cPort = I2C.Port.kOnboard;

  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);


  public WheelOfFortuneRotator() {

  }

  @Override
  public void periodic() {
    readSensor();
  }

  private void readSensor(){

    Color detectedColor = m_colorSensor.getColor();

    double IR = m_colorSensor.getIR();

    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("IR", IR);

    int proximity = m_colorSensor.getProximity();

    SmartDashboard.putNumber("Proximity", proximity);
    
  }
 
}

