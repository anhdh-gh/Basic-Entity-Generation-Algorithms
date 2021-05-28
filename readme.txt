-cách chạy: mọi người click chuột vào vùng trống bên phải
	+với bài vẽ đoạn thẳng thì chấm 2 phát là đỉnh đầu và cuối
	+bài elip + đường tròn chấm 1 phát là tâm
	+bài đa giác thì chấm các đỉnh(nhỏ thôi k có tt chạy chậm)
	+tìm giao điểm chấm 4 lần là 2 đoạn thẳng
-bài 1: vẽ đoạn thẳng bresenham: thuật toán như trong sgk (4 loại k - xem trong code + sách)
-bài 2: midpoint đoạn thẳng: thuật toán như trong sgk (4 loại k - xem trong code + sách)
-bài 3, 4: như trong sách.
-bài sinh ký tự: dùng thuật toán bitmap (link tham khảo: http://knowledgepedia4u.blogspot.com/2013/06/character-generation-in-c-using-bitmap.html)
-sinh đa giác: 
	+ với đường bao thì dùng midpoint để nối các điểm với nhau, khi ấn start sẽ nối điểm đầu với cuối
	+ với tô kín thì dùng scanline (link tham khảo: https://l.facebook.com/l.php?u=https%3A%2F%2Ftuhoclaptrinh.cachhoc.net%2F2017%2F03%2F19%2Fbai-8-thuat-toan-to-mau-scanline%2F%3Ffbclid%3DIwAR0p2RE2jobNpUp7lM9v4RmujZsJTfMjvBNoELyqc93Pw_HXnCmZsN2D6jE%231_Gioi_thieu&h=AT1u_M4OEVS9vhHr2TDJnugaTu4deEaxNxZmS3H4emj_D9jvcHp07mpXDYgmgILDIXuFlDvGRG32b1btYwydJ1alNAYNcj0C6YXPvaCNWG-dkHEsQ3c0NFjqlTn2IMeK-uClfggzWy8nm-SDZHSOQA)
-tìm giao điểm: 
	+vẽ 2 đoạn thẳng với midpoint.
	+tìm trong list những điểm trùng nhau.