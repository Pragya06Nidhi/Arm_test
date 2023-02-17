package frc.robot.Arm;
    import edu.wpi.first.math.controller.ArmFeedforward;
    import edu.wpi.first.math.controller.ProfiledPIDController;
    import edu.wpi.first.math.trajectory.TrapezoidProfile;
    import edu.wpi.first.math.trajectory.TrapezoidProfile.State;
    import edu.wpi.first.wpilibj.Encoder;
    import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
    import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
    import edu.wpi.first.wpilibj2.command.ProfiledPIDSubsystem;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxAlternateEncoder;
import com.revrobotics.SparkMaxRelativeEncoder.Type;

import frc.robot.Constants;
import frc.robot.Constants.ArmConstants;
import frc.robot.HardwareAdapter;
    
public class ArmSubsystem extends ProfiledPIDSubsystem implements HardwareAdapter{

    //public final Encoder encoder = new Encoder(1,2);

    public final RelativeEncoder encoder2 = motor1.getEncoder(Type.kQuadrature, Constants.ArmConstants.countsPerRev);
        
    public final MotorControllerGroup ArmMotors = new MotorControllerGroup(motor1, motor2);
    ArmFeedforward moveForward = new ArmFeedforward(Constants.ArmConstants.kS, Constants.ArmConstants.kG, Constants.ArmConstants.kV, Constants.ArmConstants.kA);
    public ArmSubsystem(){
        super(new ProfiledPIDController(1, 2,3, new TrapezoidProfile.Constraints(Constants.ArmConstants.kVMax, Constants.ArmConstants.kAMax)));
        double convertPositionToAngle = 1.0; 
        //encoder.setDistancePerPulse(1);
        //double angle = encoder2.getPosition() * convertPositionToAngle; 
        encoder2.setPosition(0);
        encoder2.setPositionConversionFactor(convertPositionToAngle);
        setGoal(ArmConstants.kArmOffsetRads);
        
    }
    
    public void useOutput(double output, TrapezoidProfile.State setpoint){
        double forward = moveForward.calculate(setpoint.position, setpoint.velocity);
        ArmMotors.setVoltage(output + forward);
        
    }


    @Override
    public double getMeasurement() {
        double convertPositionToAngle = 1.0;
        return (encoder2.getPosition() * convertPositionToAngle )+ ArmConstants.kArmOffsetRads;
    }


}