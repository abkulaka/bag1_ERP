package com.lab5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PayrollSystem {
    private static final Logger logger = LogManager.getLogger(PayrollSystem.class);

    public void addProduct(int quantity) {
        if (quantity < 0) {
            logger.error("Алдаа: Сөрөг тоо оруулсан байна: {}", quantity);
            throw new IllegalArgumentException("Тоо сөрөг байж болохгүй.");
        }
        logger.info("Бараа амжилттай нэмэгдлээ: {}", quantity);
        // Бараа нэмэх үйлдэл ...
    }
}
