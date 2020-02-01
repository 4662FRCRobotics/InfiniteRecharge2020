/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants.*;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class GetNextAutoCmd extends SequentialCommandGroup {
  Drive m_drive;
  Autonomous m_autonomous;
  
  /**
   * Creates a new GetNextAutoCmd.
   */
  public GetNextAutoCmd(Autonomous autonomous, Drive drive) {
    
    m_drive = drive;
    m_autonomous = autonomous;

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
      case "wait":
        double time = m_autonomous.getDoubleCommandValue();
        System.out.println("Wait Command is waiting for " + time + " seconds");
        addCommands(new Wait(time));
        break;
      
      case "driveDistance":
        double distance = m_autonomous.getDoubleCommandValue();
        System.out.println("Drive Distance is driving for " + distance + " in");
        //addCommands(new DriveDistance(distance, m_drive));
        addCommands(new DriveDistance(-distance * DriveConstants.kPULSE_PER_ROTATION * DriveConstants.kGEARBOX_REDUCTION / (DriveConstants.kTIRE_SIZE * Math.PI), m_drive));
        break;

      case "turnToAngle":
        //System.out.println("Turn angle value: " + angle);
        double angle = m_autonomous.getDoubleCommandValue();
        System.out.println("Turn Angle is turning for " + angle + " degrees");
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
