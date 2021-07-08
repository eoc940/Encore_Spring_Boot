<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        h1 {
            font-size: 24px;
            background: #ddd;
            text-align: center;
            padding: 15px;
        }
        .point {
            color: orange;
        }
        #entrance {
            border: 1px solid #ddd;
            width: 700px;
            margin: 10px auto;
        }
        #entrance > p:nth-of-type(1) {
            text-align: right;
            padding: 5px;
        }
        #entrance > p:nth-of-type(2) {
            background: #ddd;
            width: 100%;
            height: 30px;
        }
        #entrance form label{
            border-right: 1px solid #ddd;
            display: inline-block;
            padding: 5px;
            padding-right: 20px;
            margin-left: 20px;
            width: 120px;
        }
        #entrance form span {
           margin-bottom: 8px;
           display: inline-block;
        }
        #entrance form p:nth-of-type(1) input {
            width: 120px;
            padding: 2px;
        }
        #entrance form p:nth-of-type(2) input {
            width: 480px;
            padding: 2px;
        }
        #entrance form p:nth-of-type(3) select {
            width: 200px;
            padding: 2px;
        }
        #entrance form p:nth-of-type(10){
           display: flex;
           justify-content: center;
           background: #ddd;
           align-items: center;
        }
        #entrance form p:nth-of-type(10) input {
            padding: 5px;
            margin: 10px 5px;
            cursor: pointer;
        }
        footer {
            font-size: 0.8em;
            color: blue;
            text-align: center;
            line-height: 1.8;
        }
    </style>
</head>
<body>
    <h1>도서 등록 화면</h1>
    <div id="entrance">
        <p><span class="point">*</span> 표시가 된 항목은 필수 입력 항목입니다.</p>
        <p></p>
        <form action="addBook.do" method="post" id="frm">
        <input type="hidden" name="command" value="book">
            <p>
                <label for="bookNo"><span class="point">*</span> 도서번호</label>
                <span><input type="text" name="isbn" id="bookNo1" required> - <input type="text" name="isbn" id="bookNo2" required> - <input type="text" name="isbn" id="bookNo3" required></span>
            </p>
            <p>
                <label for="bookTitle"><span class="point">*</span> 도서제목</label>
                <span><input type="text" name="title" id="bookTitle" required></span>
            </p>
            <p>
                <label for="bookCategory"><span class="point">*</span> 도서종류</label>
                <span>
                    <select name="catalogue" id="bookCatalogue">
                        <option>프로그래밍</option>
                        <option>운영체제</option>
                        <option>데이터베이스</option>
                        <option>보안</option>
                    </select>
                </span>
            </p>
            <p>
                <label for="bookCountry">* 출판국가</label>
                <span>
                    <input type="radio" name="country" id="bookCountry" value="국내도서"> 국내도서
                    <input type="radio" name="country" id="bookCountry" value="외국도서"> 외국도서
                </span>
            </p>
            <p>
                <label for="bookDate">* 출 판 일</label>
                <span>
                    <input type="date" name="publish_date" value="bookDate">
                </span>
            </p>
            <p>
                <label for="bookPublisher">* 출 판 사</label>
                <span>
                    <select name="publisher" id="bookPublisher">
                        <option>엔코아</option>
                        <option>한빛미디어</option>
                        <option>길벗</option>
                        <option>이지스퍼블리싱</option>
                    </select>
                </span>
            </p>
            <p>
                <label for="bookAuthor"><span class="point">*</span> 저 자</label>
                <span><input type="text" name="author" id="bookAuthor" required></span>
            </p>
            <p>
                <label for="bookPrice"><span>*</span> 도서가격</label>
                <span><input type="text" name="price" id="bookPrice">
                    <select name="bookPrice2" id="bookPrice2">
                        <option>원</option>
                        <option>달러</option>
                    </select>
                </span>
            </p>
            <p>
                <label for="bookSummary"><span>*</span> 요약내용</label>
                <textarea name="bookSummary" id="bookSummary" cols="40" rows="2"></textarea>
            </p>
            <p>
                <input type="submit" value="도서등록">
                <input type="reset" value="취소">
            </p>
        </form>
    </div>
    <footer>
        <p>사전 도움말 - 이용약관 - 개인정보취급방침 - 책임의 한계와 법적고지 - 고객센터</p>
        <p>Copyright ⓒ 2020. HaBaRee. All Rights Reserved.</p>
    </footer>
</body>
</html>