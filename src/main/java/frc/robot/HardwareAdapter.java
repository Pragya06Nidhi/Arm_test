package frc.robot;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
// import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
// import frc.robot.subsystems.Pneumatics;

// import edu.wpi.first.networktables.NetworkTable;
// import edu.wpi.first.networktables.NetworkTableInstance;

public interface HardwareAdapter{
    public final CANSparkMax motor1 = new CANSparkMax(1, MotorType.kBrushless); 
    public final CANSparkMax motor2 = new CANSparkMax(2, MotorType.kBrushless); 

    
}
