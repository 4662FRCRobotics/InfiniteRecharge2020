/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.*;
import frc.robot.Constants;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class GetNextAutoCmd extends SequentialCommandGroup {
  Drive m_drive;
  
  /**
   * Creates a new GetNextAutoCmd.
   */
  public GetNextAutoCmd(Autonomous autonomous, Drive drive) {
    
    m_drive = drive;

    String command = "";

    do {
      command = autonomous.getNextCmd();
      ProcessCommand(command);
    } while (!autonomous.isFinished());


    if(command != ""){
      addCommands(new StartGetNextCmd(autonomous, drive));
    }else{
      System.out.println("exiting command loop");
    }
    
  }
  private void ProcessCommand(String command){
    System.out.println("Scheduled Command: " + command);
    switch (command) {
      /*case "wait":
        double timeout = Robot.m_autonomous.getDoubleCommandValue();
        System.out.println("Wait value: " + timeout);
        addSequential (new WaitCommand(timeout));
        break;
      
      case "timedMove":
        double duration = Robot.m_autonomous.getDoubleCommandValue();
        System.out.println("Timed moved value: " + duration);
        addSequential (new TimedMove(duration));
        break;*/

      case "turnToAngle":
        //System.out.println("Turn angle value: " + angle);
        System.out.println("Angle Turning is done.");
        double angle = 15;
        addCommands(new TurnToAngle(angle, m_drive));
        break;

      case "":
        System.out.println("No command is commanding.");
        break;

      default:
        System.out.println("Unrecognized command: " + command);
    }
  }
}
