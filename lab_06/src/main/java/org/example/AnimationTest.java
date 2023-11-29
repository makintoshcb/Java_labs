package org.example;


// Абстрактный класс для анимации
abstract class Animation {
    private int duration;
    private long startTime;

    // Конструктор
    public Animation(int duration) {
        this.duration = duration;
    }

    // Метод для начала анимации
    public void start() {
        startTime = System.currentTimeMillis();
        System.out.println("Анимация начата.");
    }

    // Абстрактный метод для обновления состояния анимации
    abstract void update(float progress);

    // Метод для обновления анимации
    public void updateAnimation() {
        long currentTime = System.currentTimeMillis();
        float elapsedTime = (float)(currentTime - startTime) / duration;

        if (elapsedTime < 1.0f) {
            update(elapsedTime);
        } else {
            update(1.0f);
            stop();
        }
    }

    // Метод для завершения анимации
    public void stop() {
        System.out.println("Анимация завершена.");
    }
}

// Класс для анимации перемещения
class MoveAnimation extends Animation {
    private float startX, startY;
    private float endX, endY;

    public MoveAnimation(int duration, float startX, float startY, float endX, float endY) {
        super(duration);
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    @Override
    void update(float progress) {
        float currentX = startX + (endX - startX) * progress;
        float currentY = startY + (endY - startY) * progress;
        System.out.println("Перемещение: (" + currentX + ", " + currentY + ")");
    }
}

// Класс для анимации вращения
class RotateAnimation extends Animation {
    private float startAngle, endAngle;

    public RotateAnimation(int duration, float startAngle, float endAngle) {
        super(duration);
        this.startAngle = startAngle;
        this.endAngle = endAngle;
    }

    @Override
    void update(float progress) {
        float currentAngle = startAngle + (endAngle - startAngle) * progress;
        System.out.println("Вращение: " + currentAngle + " градусов");
    }
}

// Класс для анимации масштабирования
class ScaleAnimation extends Animation {
    private float startScale, endScale;

    public ScaleAnimation(int duration, float startScale, float endScale) {
        super(duration);
        this.startScale = startScale;
        this.endScale = endScale;
    }

    @Override
    void update(float progress) {
        float currentScale = startScale + (endScale - startScale) * progress;
        System.out.println("Масштабирование: " + currentScale);
    }
}

// Класс для тестирования
public class AnimationTest {
    public static void main(String[] args) {
        // Создание анимаций
        Animation moveAnimation = new MoveAnimation(1000, 0, 0, 100, 100);
        Animation rotateAnimation = new RotateAnimation(2000, 0, 180);
        Animation scaleAnimation = new ScaleAnimation(1500, 1, 2);

        // Запуск анимаций
        moveAnimation.start();
        rotateAnimation.start();
        scaleAnimation.start();

        // Обновление анимаций
        while (true) {
            moveAnimation.updateAnimation();
            rotateAnimation.updateAnimation();
            scaleAnimation.updateAnimation();
        }
    }
}