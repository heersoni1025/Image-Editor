# File-I-O-and-Image-Processing


Description

A Java Swing-based image editor that provides basic image manipulation features such as grayscale conversion, color inversion, mirroring, rotation, and zooming, along with undo/redo functionality and keyboard shortcuts for a smoother experience.

Features
- File Operations
- Open & Save Images – Supports PPM format.
- Keyboard Shortcuts for quick actions.
  - CTRL + O → Open Image
  - CTRL + S → Save Image
  - CTRL + Z → Undo
  - CTRL + Y → Redo

Image Transformations
- Grayscale Conversion – Convert images to black & white.
- Color Inversion – Invert all image colors.
- Zero Red Filter – Remove red components from the image.
- Mirroring – Reflect the image horizontally or vertically.
- Rotation – Rotate images clockwise or counterclockwise.
- Zooming – Right-click and use the mouse wheel to zoom in/out.
- Repeat Image – Duplicate the image horizontally or vertically.

User Interface & Functionality
- Graphical User Interface (GUI) built with Java Swing.
- Undo/Redo Support – Easily revert changes.
- Tools Menu – Apply transformations with an intuitive menu system.

Technologies Used
- Java
- Swing (GUI Framework)
- BufferedImage for Image Processing
- PPM Image File Handling

Usage Guide
- Open an Image: Use the File Menu to load an image.
- Apply Transformations: Use the Tools Menu to modify images.
- Undo/Redo Changes: Easily revert edits using shortcut keys.
- Save Image: Use Save As from the File Menu.

Images of some features:

<img width="511" alt="Screenshot 2025-06-28 at 7 09 17 PM" src="https://github.com/user-attachments/assets/cabc7247-2f61-432f-975b-3c8e29d660cf" />

<img width="511" alt="Screenshot 2025-06-28 at 7 09 36 PM" src="https://github.com/user-attachments/assets/2ae3e525-397b-41b8-8d05-adac1708723f" />

Image with horizontal mirror (You can also do a vertical mirror)
<img width="511" alt="Screenshot 2025-06-28 at 7 09 59 PM" src="https://github.com/user-attachments/assets/e0d547b1-06d5-4d0b-9639-f298ba46b42f" />

Undo and redo commands
<img width="508" alt="Screenshot 2025-06-28 at 7 10 38 PM" src="https://github.com/user-attachments/assets/3e033945-adcb-44c4-9d58-76a3f57108eb" />

Rotated Clockwise (you can also do counter-clockwise)
<img width="510" alt="Screenshot 2025-06-28 at 7 11 30 PM" src="https://github.com/user-attachments/assets/171c3fe3-df67-4a0c-8e44-db40b6132a9d" />

Greyscale, inverted, and repeated horizontally twice (you can scroll through it)
<img width="509" alt="Screenshot 2025-06-28 at 7 13 21 PM" src="https://github.com/user-attachments/assets/6f6767a8-422e-4bb1-8486-a07bdd8845fc" />


Red Zero 
<img width="511" alt="Screenshot 2025-06-28 at 7 14 27 PM" src="https://github.com/user-attachments/assets/1d69e9c6-1f5d-4797-ac4f-f64cb200f3fb" />



Acknowledgments

Developed as a Java Swing project for educational purposes. Inspired by basic image editing software.
