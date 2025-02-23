import java.awt.*;
import java.awt.image.BufferedImage;

class ImageOperations {

    /**
     * Sets the red component of each pixel to zero and removes all red color from the image.
     *
     * @param img The original image to modify.
     * @return A new BufferedImage with the red component set to zero for each pixel.
     */
    static BufferedImage zeroRed(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color original = new Color(img.getRGB(x, y));
                Color modified = new Color(0, original.getGreen(), original.getBlue());
                result.setRGB(x, y, modified.getRGB());
            }
        }
        return result;
    }

    /**
     * Converts the given image to grayscale
     *
     * @param img The original image to convert to grayscale.
     * @return A new BufferedImage that is the grayscale version of the original image.
     */
    static BufferedImage grayscale(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage newImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color original = new Color(img.getRGB(x, y));
                int gray = (int) (original.getRed() * 0.3 + original.getGreen() * 0.59 + original.getBlue() * 0.11);
                Color grayColor = new Color(gray, gray, gray);
                newImg.setRGB(x, y, grayColor.getRGB());
            }
        }
        return newImg;
    }

    /**
     * Inverts the colors of the image by subtracting each RGB component from 255.
     *
     * @param img The original image to invert.
     * @return A new BufferedImage with the colors inverted.
     */
    static BufferedImage invert(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage newImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color original = new Color(img.getRGB(x, y));
                Color inverted = new Color(255 - original.getRed(), 255 - original.getGreen(), 255 - original.getBlue());
                newImg.setRGB(x, y, inverted.getRGB());
            }
        }
        return newImg;
    }

    /**
     * Mirrors the image either vertically or horizontally based on the specified direction.
     * For vertical mirroring, the left side of the image is reflected to the right side.
     * For horizontal mirroring, the top of the image is reflected to the bottom.
     *
     * @param img The original image to mirror.
     * @param dir The direction to mirror the image, either VERTICAL or HORIZONTAL.
     * @return A new BufferedImage with the mirrored effect applied.
     */
    static BufferedImage mirror(BufferedImage img, MirrorMenuItem.MirrorDirection dir) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage newImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        if (dir == MirrorMenuItem.MirrorDirection.VERTICAL) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width / 2; x++) {

                    int rgb = img.getRGB(x, y);
                    newImg.setRGB(x, y, rgb);
                    newImg.setRGB(width - x - 1, y, rgb);
                }
            }
        } else {
        for (int y = 0; y < height / 2; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = img.getRGB(x, y);
                newImg.setRGB(x, y, rgb);

                newImg.setRGB(x, height - y - 1, rgb);
            }

            }
        }
        return newImg;

    }

    /**
     * Rotates the image either clockwise or counterclockwise based on the specified direction.
     *
     * @param img The original image to rotate.
     * @param dir The direction to rotate the image, either CLOCKWISE or COUNTERCLOCKWISE.
     * @return A new BufferedImage with the rotated image.
     */
    static BufferedImage rotate(BufferedImage img, RotateMenuItem.RotateDirection dir) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage newImg = new BufferedImage(height, width, BufferedImage.TYPE_INT_RGB);

        if (dir == RotateMenuItem.RotateDirection.CLOCKWISE) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int rgb = img.getRGB(x, y);
                    newImg.setRGB(height - y - 1, x, rgb);
                }
            }
        } else {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int rgb = img.getRGB(x, y);
                    newImg.setRGB(y, width - x - 1, rgb);
                }
            }}
        return newImg;
    }

    /**
     * Repeats the image either horizontally or vertically.
     * If the direction is horizontal, the image is repeated n times side by side.
     * If the direction is vertical, the image is repeated n times stacked on top of each other.
     *
     * @param img The original image to repeat.
     * @param n The number of times to repeat the image.
     * @param dir The direction to repeat the image
     * @return A new BufferedImage with the repeated image.
     */
    static BufferedImage repeat(BufferedImage img, int n, RepeatMenuItem.RepeatDirection dir) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage newImg;

        if (dir == RepeatMenuItem.RepeatDirection.HORIZONTAL) {
            newImg = new BufferedImage(width * n, height, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < n; i++) {
                for (int y = 0; y < height; y++) {
                    for (int x = 0; x < width; x++) {
                        int rgb = img.getRGB(x, y);
                        newImg.setRGB(x + (i * width), y, rgb);}}}
        } else {
            newImg = new BufferedImage(width, height * n, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < n; i++) {
                for (int y = 0; y < height; y++) {
                    for (int x = 0; x < width; x++) {
                        int rgb = img.getRGB(x, y);
                        newImg.setRGB(x, y + (i * height), rgb);}}}}
        return newImg;
    }


    /**
     * Zooms in on the image. The zoom factor increases in multiplicatives of 10% and
     * decreases in multiplicatives of 10%.
     *
     * @param img        the original image to zoom in on. The image cannot be already zoomed in
     *                   or out because then the image will be distorted.
     * @param zoomFactor The factor to zoom in by.
     * @return the zoomed in image.
     */
    static BufferedImage zoom(BufferedImage img, double zoomFactor) {
        int newImageWidth = (int) (img.getWidth() * zoomFactor);
        int newImageHeight = (int) (img.getHeight() * zoomFactor);
        BufferedImage newImg = new BufferedImage(newImageWidth, newImageHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = newImg.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(img, 0, 0, newImageWidth, newImageHeight, null);
        g2d.dispose();
        return newImg;
    }
}
