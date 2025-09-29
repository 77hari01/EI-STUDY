# Command Pattern – Remote Control

This project demonstrates the **Command Design Pattern** using a **Remote Control** example for **Lights** and an **Air Conditioner (AC)**. The Command pattern encapsulates requests as objects, allowing you to decouple the invoker from the receiver and execute operations dynamically.

## Use Case

The use case is to simulate a **Remote Control** that can:
- Turn **Light ON/OFF**
- Turn **AC ON/OFF**

Each action is represented as a **Command** object, and the **RemoteControl (Invoker)** can execute any command without knowing the details of the operation.

## Implementation

### 1. Command Interface
Declares the method `execute()` which is implemented by all concrete commands.

### 2. Receiver Classes
- **Light** → Has `on()` and `off()` methods
- **AirConditioner** → Has `on()` and `off()` methods

### 3. Concrete Command Classes
- `LightOnCommand`, `LightOffCommand` → Executes actions on the Light
- `ACOnCommand`, `ACOffCommand` → Executes actions on the AC

### 4. Invoker (RemoteControl)
- Maintains a reference to a `Command` object
- `setCommand()` → Assigns a command
- `pressButton()` → Executes the assigned command

### 5. Client
- Creates receivers, commands, and the invoker
- Assigns commands to the invoker and executes them

## Example Output

```
Light is ON
Light is OFF
AC is ON
AC is OFF
```

