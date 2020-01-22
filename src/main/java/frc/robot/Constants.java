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
    public static final class ContestantConstants {
        public static final String BLUE_STRING = "Blue";
        public static final String RED_STRING = "Red";
        public static final String GREEN_STRING = "Green";
        public static final String YELLOW_STRING = "Yellow";

        public enum Color {
            RED(0.531006, 0.337158, 0.128906, RED_STRING),
            BLUE(0.119873, 0.414551, 0.465820, BLUE_STRING),
            YELLOW(0.321289, 0.555908, 0.123291, YELLOW_STRING),
            GREEN(0.165527, 0.573975, 0.260010, GREEN_STRING);

            private double m_dRed;
            private double m_dGreen;
            private double m_dBlue;

            private String m_name;

            Color(double red, double green, double blue, String name) {
                this.m_dRed = red;
                this.m_dBlue = blue;
                this.m_dGreen = green;
                this.m_name = name;
            }
            public double getRed(){
                return m_dRed;
            }

            public double getGreen(){
                return m_dGreen;
            }

            public double getBlue(){
                return m_dBlue;
            }

            public final String getName(){
                return m_name;
            }
        }
    }
    
}

