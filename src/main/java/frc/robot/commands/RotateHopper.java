/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;

public class RotateHopper extends CommandBase {
  /**
   * Creates a new FeedHopper.
   */
  private Hopper m_hopper;

  public RotateHopper(Hopper hopper) {
    m_hopper = hopper;
    addRequirements(m_hopper);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_hopper.setTarget();
    m_hopper.setHopperMotorOn();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_hopper.setHopperMotorOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_hopper.shouldHopperStop();
  }
}
