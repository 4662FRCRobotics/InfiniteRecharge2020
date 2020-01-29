/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class LoadAutoXML extends CommandBase {
  private final Autonomous m_autonomous;
  /**
   * Creates a new LoadAutoXML.
   */
  public LoadAutoXML(Autonomous autonomous) {
    m_autonomous = autonomous;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_autonomous);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_autonomous.getXML();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
