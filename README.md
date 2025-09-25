# Face Recognition Attendance System

A **Flask-based web application** that automates attendance using face recognition. Users are identified via webcam, and attendance is recorded automatically with timestamps.

---

## Project Overview

The **Face Recognition Attendance System** simplifies attendance management using computer vision and machine learning. It provides:

- Real-time face detection and recognition.
- Automated attendance logging.
- User management (add/delete users) with automatic model retraining.
- CSV-based daily attendance storage.

### Architecture

- **Frontend:** HTML, CSS, Jinja2 templates for user interaction.
- **Backend:** Flask handles routing, business logic, and APIs.
- **Face Detection & Recognition:** OpenCV (Haar Cascades) and scikit-learn (KNN Classifier).
- **Data Storage:** Local file system (`static/faces/`) and CSV files (`Attendance/Attendance-MM_DD_YY.csv`).
- **ML Model Storage:** `face_recognition_model.pkl` via `joblib`.

---

## Folder Structure
face-recognition-attendance-system/
│
├── app.py # Main Flask application
├── requirements.txt # Python dependencies
├── static/
│ └── faces/ # User images folders (username_id)
├── Attendance/ # CSV attendance files
├── templates/
│ ├── home.html
│ ├── attendance.html
│ └── add_user.html
├── haarcascade_frontalface_default.xml
└── README.md

---

## Features

- Real-time attendance capture with webcam.
- Add new users with multiple images for training.
- Automatic model training with KNN classifier.
- Delete users and retrain model.
- View attendance for the day with timestamp.
- Responsive modern web interface.

---

## API Endpoints

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/` | GET | Home page showing attendance and total users |
| `/attendance` | GET | View all users and today's attendance |
| `/add_user` | GET | Form to add a new user |
| `/add` | POST | Capture images for new user and retrain model |
| `/start` | GET | Start real-time attendance capture |
| `/deleteuser` | GET / POST | Delete a user by user_id and retrain model |

---

## Workflow

1. **Add User**
   - Go to `/add_user`.
   - Enter name and unique ID.
   - Webcam captures multiple images.
   - Model retrains automatically.

2. **Take Attendance**
   - Go to `/start`.
   - Webcam detects faces in real-time.
   - Recognized faces are logged in CSV.

3. **View Attendance**
   - Visit `/attendance`.
   - Displays all users with attendance and timestamps.

4. **Delete User**
   - Click delete next to a user in `/attendance`.
   - User folder and images are removed.
   - Model retrains automatically.

---

## Setup Instructions

1. Clone repository:

```bash
git clone https://github.com/YOUR_USERNAME/face-recognition-attendance.git
cd face-recognition-attendance
---
**install dependencies:
    pip install -r requirements.txt
