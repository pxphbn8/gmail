package com.example.gmailapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setupWindowInsets()

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = EmailAdapter(getEmailList())
    }

    // Set up window insets for edge-to-edge display
    private fun setupWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Create a list of sample emails
    private fun getEmailList(): List<Email> {
        return listOf(
            Email("Khải", "Nhắc Nhở Cuộc Họp", "Đừng quên cuộc họp vào lúc 10:00 sáng", "9:15 sáng"),
            Email("Tuấn", "Cập Nhật Dự Án Mới", "Đây là cập nhật về dự án mới của chúng ta...", "Hôm qua"),
            Email("Hoàng", "Nhắc Nhở Cuộc Họp", "Đừng quên cuộc họp ngày mai...", "8:30 sáng"),
            Email("Dũng", "Ưu Đãi Đặc Biệt", "Nhận 50% giảm giá cho lần mua tiếp theo...", "9:15 sáng"),
            Email("Đạt", "Kế Hoạch Ăn Trưa", "Chúng ta có nên ăn trưa tại quán cà phê mới không?", "10:45 sáng"),
            Email("Đức", "Cập Nhật Dự Án", "Dự án đang tiến triển tốt và sẽ...", "11:20 sáng"),
            Email("Duy", "Mã Giảm Giá Bên Trong", "Mã giảm giá đặc biệt chỉ dành cho bạn...", "1:00 chiều")
        )
    }
}
