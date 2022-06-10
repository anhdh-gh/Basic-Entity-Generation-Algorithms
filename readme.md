## Ứng dụng desktop minh họa các giải thuật sinh thực thể cơ sở
## Công nghệ sử dụng
- Java 2D
- Java Swing
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
		- Tham khảo: http://knowledgepedia4u.blogspot.com/2013/06/character-generation-in-c-using-bitmap.html
	- Sinh đa giác: 
		- Với đường bao thì dùng midpoint để nối các điểm với nhau, khi ấn start sẽ nối điểm đầu với cuối
		- Với tô kín thì dùng scanline (
			- Tham khảo: https://tuhoclaptrinh.cachhoc.net/2017/03/19/bai-8-thuat-toan-to-mau-scanline/?fbclid=IwAR0p2RE2jobNpUp7lM9v4RmujZsJTfMjvBNoELyqc93Pw_HXnCmZsN2D6jE#1_Gioi_thieu
	- Tìm giao điểm: 
		- Vẽ 2 đoạn thẳng với midpoint.
		- Tìm trong list những điểm trùng nhau.
