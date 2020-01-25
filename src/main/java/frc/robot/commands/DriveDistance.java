/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.Drive;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class DriveDistance extends PIDCommand {
  private final Drive m_drive;
  /**
   * Creates a new DriveDistance.
   */
  public DriveDistance(double targetDistance, Drive drive) {
    super(
        // The controller that the command will use
        new PIDController(DriveConstants.kKEEP_HEADING_P, DriveConstants.kKEEP_HEADING_I, DriveConstants.kKEEP_HEADING_D),
        // This should return the measurement
        drive::getDistance, targetDistance,
        // This should return the setpoint (can also be a constant)
        d -> drive.arcadeDrive(d, 0));
        // This uses the output
        // Use the output here

        
    m_drive = drive;
    addRequirements(m_drive);

    getController().setTolerance(DriveConstants.kKEEP_HEADING_TOLERANCE);
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
  }

  // Returns true when the command should end.

public void initialize() {
    // Get everything in a safe starting state.
    m_drive.reset();
    super.initialize();
  }  
  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
