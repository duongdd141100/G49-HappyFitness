package com.example.happy_fitness.common;

import lombok.Getter;

@Getter
public enum ErrorMessageEnum {
    LOGIN_FAILED("001001", "Đăng nhập thất bại!"),

    TOKEN_EMPTY("001002", "Token trống"),

    TOKEN_INVALID("001003", "Token không hợp lệ"),

    CREATE_TOKEN_FAILED("001004", "Khởi tạo token thất bại"),

    LACK_OF_INFORMATION("001005", "Thiếu thông tin"),

    USERNAME_EXIST("001006", "Tên người dùng đã tồn tại! Vui lòng nhập tên người dùng khác!"),

    USERNAME_NOT_EXIST("001007", "Tên người dùng không tồn tại!"),

    /**
     * Error message for email
     */
    EMAIL_NOT_EXIST("002001", "Email không tồn tại!"),

    SEND_MAIL_FAILED("002002", "Gửi mail thất bại!"),

    /**
     * Error message for authentication
     */
    ERROR_CREATE_NEW_USER_BECAUSE_ROLE("003001", "Bạn không thể tạo người dùng mới với quyền Admin, Quản Lý, hoặc Khách Hàng!"),

    ERROR_CREATE_NEW_USER_BECAUSE_FACILITY("003002", "Bạn không thể tạo người dùng mới cho cơ sở khác!"),

    ACCESS_DENIED_VIEW_USER_DETAIL("003003", "Bạn chỉ có thể xem nhân viên trong cơ sở của bạn!"),

    ACCESS_DENIED_RESET_PASSWORD("003004", "Bạn chỉ có thể đặt lại mật khẩu cho nhân viên trong cơ sở của bạn!"),

    CANNOT_DEACTIVATE_YOUR_SELF("003005", "Bạn không thể vô hiệu hoá tài khoản của chính bạn!"),

    ACCESS_DENIED_DEACTIVATE_USER("003006", "Bạn chỉ có thể vô hiệu hoá tài khoản của nhân viên trong cơ sở bạn!"),

    /**
     * Error message for product
     */
    PRODUCT_NOT_EXIST("004001", "Sản phẩm không tồn tại!"),

    PRODUCT_CODE_NULL("004002", "Mã sản phẩm không đươc để trống!"),

    PRODUCT_NOT_ACTIVE("004003", "Sản phẩm không hoạt động!"),

    PRODUCT_NOT_ENOUGH("004004", "Số lượng sản phẩm trong kho không đủ!"),

    /**
     * Error message for voucher
     */
    VOUCHER_NOT_EXIST("005001", "Voucher không tồn tại!"),

    VOUCHER_NOT_VALID("005002", "Voucher không hợp lệ!"),

    /**
     * Error message for order
     */
    ORDER_EMPTY("006001", "Không có sản phẩm được order!"),

    /**
     * Error message for facility
     */
    FACILITY_EMPTY("007001", "Không có chi nhánh được chọn!"),

    FACILITY_NOT_EXIST("007002", "Chi nhánh không tồn tại!"),

    /**
     * Error message for tickets
     */
    TICKET_NOT_EXIST("008001", "Vé không tồn tại!"),
    CANNOT_DEACTIVATE_TICKET("008002", "Bạn không thể vô hiệu hoá vé của cơ sở khác!"),

    /**
     * Error message for customer ticket
     */
    TICKET_UNEXPIRED("009001", "Vé của bạn chưa hết hạn!"),

    HAS_TICKET_ACTIVE("009002", "Bạn còn vé đang hoạt động!"),;

    private String code;

    private String message;

    ErrorMessageEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ErrorMessageEnum typeOf(String code) {
        for (ErrorMessageEnum messageEnum : ErrorMessageEnum.values()) {
            if (messageEnum.code.equals(code)) {
                return messageEnum;
            }
        }
        throw new IllegalArgumentException(code);
    }
}
