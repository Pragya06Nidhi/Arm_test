// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Commands.ArmRun; 
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Arm.ArmSubsystem; 
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  public static final ArmSubsystem arm = new ArmSubsystem();
  public static final XboxController xbox = new XboxController(1);
  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    if (xbox.getAButtonPressed()){
      Commands.runOnce(() -> {arm.setGoal(2); arm.enable();},arm);
    }
    
    
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
