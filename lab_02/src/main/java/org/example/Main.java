package org.example;
// Интерфейс для фабрик изображений
interface ImageFactory {
    ImageReader createImageReader();
    ImageWriter createImageWriter();
}

// Фабрика для JPG формата
class JpgImageFactory implements ImageFactory {
    @Override
    public ImageReader createImageReader() {
        return new JpgImageReader();
    }

    @Override
    public ImageWriter createImageWriter() {
        return new JpgImageWriter();
    }
}

// Фабрика для PNG формата
class PngImageFactory implements ImageFactory {
    @Override
    public ImageReader createImageReader() {
        return new PngImageReader();
    }

    @Override
    public ImageWriter createImageWriter() {
        return new PngImageWriter();
    }
}

// Фабрика для GIF формата
class GifImageFactory implements ImageFactory {
    @Override
    public ImageReader createImageReader() {
        return new GifImageReader();
    }

    @Override
    public ImageWriter createImageWriter() {
        return new GifImageWriter();
    }
}

// Интерфейс для чтения изображений
interface ImageReader {
    void readImage(String filename);
}

// Интерфейс для записи изображений
interface ImageWriter {
    void writeImage(String filename);
}

// Реализация чтения изображений для JPG формата
class JpgImageReader implements ImageReader {
    @Override
    public void readImage(String filename) {
        System.out.println("Чтение изображения в формате JPG: " + filename);
    }
}

// Реализация записи изображений для JPG формата
class JpgImageWriter implements ImageWriter {
    @Override
    public void writeImage(String filename) {
        System.out.println("Запись изображения в формате JPG: " + filename);
    }
}

// Реализация чтения изображений для PNG формата
class PngImageReader implements ImageReader {
    @Override
    public void readImage(String filename) {
        System.out.println("Чтение изображения в формате PNG: " + filename);
    }
}

// Реализация записи изображений для PNG формата
class PngImageWriter implements ImageWriter {
    @Override
    public void writeImage(String filename) {
        System.out.println("Запись изображения в формате PNG: " + filename);
    }
}

// Реализация чтения изображений для GIF формата
class GifImageReader implements ImageReader {
    @Override
    public void readImage(String filename) {
        System.out.println("Чтение изображения в формате GIF: " + filename);
    }
}

// Реализация записи изображений для GIF формата
class GifImageWriter implements ImageWriter {
    @Override
    public void writeImage(String filename) {
        System.out.println("Запись изображения в формате GIF: " + filename);
    }


//public class GraphicsEditor {
    public static void main(String[] args) {
        // Создание объектов фабрик изображений
        ImageFactory jpgFactory = new JpgImageFactory();
        ImageFactory pngFactory = new PngImageFactory();
        ImageFactory gifFactory = new GifImageFactory();

        // Создание объектов чтения и записи изображений для каждой фабрики
        ImageReader jpgReader = jpgFactory.createImageReader();
        ImageWriter jpgWriter = jpgFactory.createImageWriter();

        ImageReader pngReader = pngFactory.createImageReader();
        ImageWriter pngWriter = pngFactory.createImageWriter();

        ImageReader gifReader = gifFactory.createImageReader();
        ImageWriter gifWriter = gifFactory.createImageWriter();

        // Использование объектов для чтения и записи изображений
        jpgReader.readImage("image.jpg");
        jpgWriter.writeImage("image.jpg");

        pngReader.readImage("image.png");
        pngWriter.writeImage("image.png");

        gifReader.readImage("image.gif");
        gifWriter.writeImage("image.gif");
    }
}