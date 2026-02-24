# 数字卦 Android App（修复版）

## 环境要求
- Android Studio Hedgehog 2023.1.1 或更新版本
- AGP 8.2.2，Gradle 8.2，Kotlin 1.9.22

## 导入步骤
1. 解压 ZIP，得到 ShuZiGua/ 文件夹
2. Android Studio → File → Open → 选择该文件夹
3. 等待 Gradle Sync 完成（需联网）
4. Run → 选择设备即可

## 常见问题
- 若 Gradle 版本报错，检查 gradle/wrapper/gradle-wrapper.properties 中的 distributionUrl
- 若 AGP 版本报错，将 build.gradle 中的 8.2.2 改为与你的 Android Studio 匹配的版本
