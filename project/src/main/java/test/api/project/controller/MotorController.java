package test.api.project.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.api.project.model.Motor;

@RestController
@RequestMapping("/api/info")
public class MotorController {

    // Danh sách lưu trữ motor (có thể thay thế bằng cơ sở dữ liệu trong thực tế)
    private List<Motor> motorList = new ArrayList<>(Arrays.asList(
            new Motor(1L, "Exciter 155 VVA", "Yamaha", "Xanh GP", 2021),
            new Motor(2L, "Vario 125", "Honda", "White", 2019)
    ));

    // API để lấy danh sách tất cả motor
    @GetMapping
    public List<Motor> getMotors() {
        return motorList;
    }

    // API để tạo motor mới
    @PostMapping
    public Motor createMotor(@RequestBody Motor motor) {
        // Giả sử motor được tạo với ID mới tự động tăng
        long newId = motorList.size() + 1;
        motor.setId(newId); // Set ID cho motor mới
        motorList.add(motor); // Lưu motor vào danh sách

        return motor; // Trả về đối tượng motor mới đã được tạo
    }

    // API để sửa motor theo ID
    @PutMapping("/{id}")
    public Motor updateMotor(@PathVariable long id, @RequestBody Motor updatedMotor) {
        Optional<Motor> motorOptional = motorList.stream()
                .filter(motor -> motor.getId() == id)
                .findFirst();

        if (motorOptional.isPresent()) {
            Motor motor = motorOptional.get();
            motor.setName(updatedMotor.getName());
            motor.setBrand(updatedMotor.getBrand());
            motor.setColor(updatedMotor.getColor());
            motor.setYear(updatedMotor.getYear());
            return motor; // Trả về motor đã được cập nhật
        } else {
            throw new RuntimeException("Motor with ID " + id + " not found.");
        }
    }

    // API để xóa motor theo ID
    @DeleteMapping("/{id}")
    public String deleteMotor(@PathVariable long id) {
        Optional<Motor> motorOptional = motorList.stream()
                .filter(motor -> motor.getId() == id)
                .findFirst();

        if (motorOptional.isPresent()) {
            motorList.remove(motorOptional.get());
            return "Motor with ID " + id + " has been deleted.";
        } else {
            throw new RuntimeException("Motor with ID " + id + " not found.");
        }
    }
}
