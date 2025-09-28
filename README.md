# Resto-POS System

## System Flow
```mermaid
flowchart TD
    A([Start]) --> B[/Login Screen/]
    B --> C{Verify Credentials}
    C -->|Valid| D[Load UI Based on Role]
    C -->|Invalid| B
    D --> E[User Performs Tasks]
    E --> F[[Logout / Exit]]
    F --> G([End])
