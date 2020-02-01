/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class DriveConstants {
        public static final int kLeftMotor1Port = 2;
        public static final int kLeftMotor2Port = 3;
        public static final int kRightMotor1Port = 4;
        public static final int kRightMotor2Port = 5;

        public static final double kRAMP_RATE = 1.0;
        public static final int kCURRENT_LIMT = 40;

        public static final double kGEARBOX_REDUCTION = (50/12) * (60/14);
        public static final double kTIRE_SIZE = 7.9;
        public static final double kPULSE_PER_ROTATION = 1;

        public static final double kTURN_ANGLE_P = 0.2;
        public static final double kTURN_ANGLE_I = 0.0;
        public static final double kTURN_ANGLE_D = 0.4;
        public static final double kTURN_ANGLE_TOLERANCE = 2;
        public static final double kTURN_ANGLE_TOLERANCE_DEG_PER_S = 10;

        public static final double kKEEP_HEADING_P =  0.2;
		public static final double kKEEP_HEADING_I =  0.0;
		public static final double kKEEP_HEADING_D = 0.4;
        public static final double kKEEP_HEADING_TOLERANCE =  1;
        
       
    }
}
