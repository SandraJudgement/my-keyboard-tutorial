class KeyboardSettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.keyboardsettinglayout)

        // ボタン要素（オブジェクト）を取得
        val buttonToMainActivity = findViewById<Button>(R.id.button_to_main)

        // ボタンタップ時のイベントリスナー
        buttonToMainActivity.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
