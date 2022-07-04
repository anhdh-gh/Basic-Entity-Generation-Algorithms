## Ứng dụng desktop minh họa các giải thuật sinh thực thể cơ sở

## Công nghệ sử dụng
- Java 2D
- Java Swing

## Hướng dân run code
- Download [JDK 8](https://www.oracle.com/java/technologies/downloads/#java8) (nếu chưa có) 
- Download [ứng dụng](https://github.com/anhdh-gh/Basic-Entity-Generation-Algorithms/releases/tag/v1.0.0) (Basic-Entity-Generation-Algorithms.jar) 

## Hình ảnh preview
### Thuật toán sinh đoạn thẳng Bresenham
<p align="center">
  <img src="https://user-images.githubusercontent.com/79781308/173054029-80140ad2-8529-41f3-bb72-4c52251e083b.png" />
</p>

### Thuật toán sinh đoạn thẳng Midpoint
<p align="center">
  <img src="https://user-images.githubusercontent.com/79781308/173054178-f7790f05-2cab-4648-bd42-42de6d88fd5c.png" />
</p>

### Thuật toán sinh đường tròn Bresenham
<p align="center">
  <img src="https://user-images.githubusercontent.com/79781308/173054350-10d23db5-61e1-4487-9e66-c3d65d4a1d3c.png" />
</p>

### Thuật toán sinh đường tròn Midpoint
<p align="center">
  <img src="https://user-images.githubusercontent.com/79781308/173057302-4bb02942-0817-4782-a6fd-0919a86cfed8.png" />
</p>

### Thuật toán sinh đường elip Bresenham
<p align="center">
  <img src="https://user-images.githubusercontent.com/79781308/173057373-670d1911-7eaf-45cc-87ee-27ae08b0e7f5.png" />
</p>

### Thuật toán sinh đường elip Midpoint
<p align="center">
  <img src="https://user-images.githubusercontent.com/79781308/173057465-e9d525c6-8d39-43aa-b3d0-c13cdc20847e.png" />
</p>

### Thuật toán sinh ký tự Bitmap
<p align="center">
  <img src="https://user-images.githubusercontent.com/79781308/173057562-3bc49efe-32e4-44ac-918b-5bcf2d4507e9.png" />
</p>

### Thuật toán tô sinh và màu đa giác
<p align="center">
  <img src="https://user-images.githubusercontent.com/79781308/173058965-422d0838-4283-4fbb-870f-12b1624d039e.png" />
</p>

### Thuật toán tìm giao điểm của hai đoạn thẳng
<p align="center">
  <img src="https://user-images.githubusercontent.com/79781308/173059243-e1850836-34e9-4b1d-b227-a04d86bf8b94.png" />
</p>

### Vẽ đồng hồ sử dụng các giải thuật
<p align="center">
  <img src="https://user-images.githubusercontent.com/79781308/173059416-34680e02-0f87-4759-b968-1854cce456bb.png" />
</p>

## Hướng dẫn run code
- Click chuột vào vùng trống bên phải
	- Với bài vẽ đoạn thẳng thì chấm 2 phát là đỉnh đầu và cuối
	- Bài elip + đường tròn chấm 1 phát là tâm
	- Bài đa giác thì chấm các đỉnh (nhỏ thôi không có thuật toán chạy chậm)
	- Tìm giao điểm thì chấm 4 lần là 2 đoạn thẳng
- Các thuật toán
	- Bresenham vẽ đoạn thẳng, đường tròn
	- Midpoint đoạn thẳng, đường tròn
	- Thuật toán bitmap sinh ký tự:
		- [Tham khảo](http://knowledgepedia4u.blogspot.com/2013/06/character-generation-in-c-using-bitmap.html)
	- Sinh đa giác: 
		- Với đường bao thì dùng midpoint để nối các điểm với nhau, khi ấn start sẽ nối điểm đầu với cuối
		- Với tô kín thì dùng scanline
			- [Tham khảo](https://tuhoclaptrinh.cachhoc.net/2017/03/19/bai-8-thuat-toan-to-mau-scanline/?fbclid=IwAR0p2RE2jobNpUp7lM9v4RmujZsJTfMjvBNoELyqc93Pw_HXnCmZsN2D6jE#1_Gioi_thieu)
	- Tìm giao điểm: 
		- Vẽ 2 đoạn thẳng với midpoint.
		- Tìm trong list những điểm trùng nhau.
