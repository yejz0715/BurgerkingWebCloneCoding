<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/Delivery/deli_header.jsp"%>

<script type="text/javascript">


			function sizeup2(){
				var ul1 = document.getElementById('ul1');
				var con = document.getElementById('ul1_set');
				con.style.height = '250px';
			}
	
			function sizedown2(){
				var ul1 = document.getElementById('ul1');
				var con = document.getElementById('ul1_set');
				con.style.height = '0px';
			}
			
			
			

			function go_save2(){	
				if(document.nonmembercheckForm.nonok.checked == false) {
				    alert("이용약관에 동의해주세요.");	    
				    document.nonmembercheckForm.nonok.focus();		
				} else if(document.nonmembercheckForm.name.value == "") {
				    alert("이름을 입력해 주세요.");	    
				    document.nonmembercheckForm.name.focus();
				} else if(document.nonmembercheckForm.phone.value == "") {
				    alert("휴대폰번호을 입력해 주세요.");	   
				    document.nonmembercheckForm.phone.focus();
				} else if(document.nonmembercheckForm.password.value == "") {
				    alert("비밀번호를 입력해 주세요.");	    
				    document.nonmembercheckForm.pwd.focus();
				} else if(document.nonmembercheckForm.password.value != document.nonmembercheckForm.passwordCheck.value) {
				    alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");	    
				    document.nonmembercheckForm.pwd.focus();
				} else{
					document.nonmembercheckForm.action ="burger.do";
					document.nonmembercheckForm.submit(); 
				}
			}			
			
			
			
			

</script>
<article>
	<div class="location">
		<ul>
			<li><a href="burger.do?command=index">HOME</a>&nbsp;>&nbsp;</li>
			<li><a href="burger.do?command=loginForm&non=1">로그인</a>&nbsp;>&nbsp;</li>
			<li><a href="burger.do?command=nonmemberForm">비회원주문</a></li>
		</ul>
	</div>

<form method="post" name="nonmembercheckForm" >
	<div class="contentsBox01">
		<div class="web_container02 container01">
			<h2 class="tit02 WEB">비회원 주문</h2>
			<h2 class="tit01 tit_ico man">
				<span>개인정보 수집</span>
			</h2>
			<div class="accWrap01">
			<p>
							<strong>수집하는 개인정보 항목</strong><br> - 전화번호, 성명, 주소
						</p>
						<br>
				<div class="container02 auth_list acc_list">
					<div class="acc_tit">
						<label><input type="checkbox" class="check02" name="nonok"><span>버거킹
								이용약관</span></label>
						<button type="button" class="btn_acc77" onmouseover="sizeup2()"
							onmouseleave="sizedown2()" id="ul1" >
							<span>상세보기</span>
						</button>
					</div><br><br>
					<div class="acc_cont" id="ul1_set">
						
							<strong>수집 목적 </strong><br> ① 성명, 주소: 제품의 전달, 청구서, 정확한 제품
							배송지의 확보.
						<br>
						<p>
							<strong>개인정보 보유기간 </strong><br> ① 계약 또는 청약철회 등에 관한 기록 : 6개월<br>
							② 대금결제 및 재화 등의 공급에 관한 기록 : 1년<br> ③ 소비자의 불만 또는 분쟁처리에 관한 기록 :
							1년
						</p>
						<br>
						<p>
							<strong>비회원 주문 시 제공하신 모든 정보는 상기 목적에 필요한 용도 이외로는 사용되지
								않습니다. 기타 자세한 사항은 '개인정보처리방침'을 참고하여주시기 바랍니다.</strong>
						</p>
					</div>
				</div>
			</div>
			<h2 class="tit01 tit_ico setting">
				<span>비회원 설정</span>
			</h2>
			<div class="container02">
				<div class="dlist01">
					<dl>
						<dt class="WEB">이름</dt>
						<dd>
							<div class="inpbox st02">
								<input type="text" placeholder="받는 분의 이름을 입력해 주세요." class="st02" name="name">
								<button type="button" class="btn_del01 " style="display: none;" >
									<span>입력 텍스트 삭제</span>
								</button>
							</div>
						</dd>
					</dl>
					<dl>
						<dt class="WEB">휴대폰 번호</dt>
						<dd>
							<div class="inpbox st02">
								<input type="text" placeholder="핸드폰 번호를 입력해 주세요" class="st02" name="phone">
							</div>
						</dd>
					</dl>
				</div>
			</div>

			<h2 class="tit01 tit_ico key">
				<span>주문서 비밀번호</span>
			</h2>
			<div class="container02">
				<div class="WEB titbox77">
					<p>주문 내역 확인을 위한 비밀번호를 입력하세요.</p>
				</div>
				<div class="dlist01">
					<dl>
						<dt class="WEB vtop">비밀번호</dt>
						<dd>
							<div class="inpbox">
								<input placeholder="비밀번호를 입력하세요." maxlength="6" type="password"
									class="st02" name="password">
								<button type="button" tabindex="-1" class="btn_view01">
									<span>입력 텍스트 보기</span>
								</button>
							</div>
							<div class="inpbox">
								<input placeholder="비밀번호를 다시 입력하세요." maxlength="6"
									type="password" class="st02" name="passwordCheck">
								<button type="button" tabindex="-1" class="btn_view01">
									<span>입력 텍스트 보기</span>
								</button>
							</div>
						</dd>
					</dl>
				</div>
			</div>

			<div class="c_btn">
				<div>
					<button type="button" class="btn01 l m_btn01" onclick="go_save2()" >
						<span>비회원 주문</span>
					</button>
				</div>
			</div>
		</div>
	</div>


	<br> <br> <br> <br> <br> <br> <br> <br>
	<br> <br> <br>
</form>
</article>
<%@ include file="/footer/footer.jsp"%>