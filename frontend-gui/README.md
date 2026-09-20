# Frontend GUI Scaffolding

This directory contains the user interface scaffolding for the Manpower Management System.

## Structure
* `index.html` - Base semantic HTML layout with navigation and main view container.
* `css/styles.css` - Design tokens, typography, and responsive container layout.
* `js/app.js` - Navigation tab switching and placeholders for CRUD Fetch API integration.

## How to Run Locally
1. **VS Code Live Server**: Right click `index.html` -> "Open with Live Server".
2. **Python HTTP Server**:
   ```bash
   cd frontend-gui
   python -m http.server 3000
   ```
3. **Browser Direct**: Open `index.html` directly in any web browser.

## Backend Connection
Make sure your Spring Boot backend is running on `http://localhost:8080`.
Configure CORS in `com.labour.placement.config.SecurityConfig` if opening the frontend from a different port (e.g., `http://localhost:3000` or Live Server `http://127.0.0.1:5500`).
