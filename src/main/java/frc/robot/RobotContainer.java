/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.WheelOfFortuneRotator;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.InternalButton;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants.ButtonMappings;
import frc.robot.Constants.ContestantConstants.Direction;



/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drive m_drive = new Drive();

  private final Joystick m_driveStick = new Joystick(0);

  private final WheelOfFortuneRotator m_contestant = new WheelOfFortuneRotator();

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {


    // Configure the button bindings
    configureButtonBindings();

    //m_driveStick = new Joystick(0);

    m_drive.setDefaultCommand(
      // A split-stick arcade command, with forward/backward controlled by the left
      // hand, and turning controlled by the right.
      new ArcadeDrive(
        m_drive,
        () -> m_driveStick.getY(),
        () -> m_driveStick.getTwist(),
        () -> m_driveStick.getThrottle()));

  }

  

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(m_driveStick, ButtonMappings.kROTATION_CONTROL).whenPressed(  // Rotation control
        new ColorWheelRotationControl(m_contestant));
    new JoystickButton(m_driveStick, ButtonMappings.kPOSITION_CONTROL).whenPressed(  // Position control
        new ConditionalCommand(
          new InstantCommand(),
          new ColorWheelPositionControl(m_contestant),
          m_contestant::isGameDataNull));
    new JoystickButton(m_driveStick, ButtonMappings.kWHEEL_OF_FORTUNE_CW).whileHeld(
        new WheelOfFortuneRotate(m_contestant, Direction.CCW));
    
    new JoystickButton(m_driveStick, ButtonMappings.kWHEEL_OF_FORTUNE_CCW).whileHeld(
      new WheelOfFortuneRotate(m_contestant, Direction.CW));
  }

  public WheelOfFortuneRotator getWheelOfFortuneRotator(){
    return m_contestant;
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }*/
}
