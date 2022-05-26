<template>
    <div>
        <section class="mypage-cont">
            <input type="hidden" id="defaultImage" name="defaultImage">
            <!-- 기본 회원정보 -->
            <section class="n-section-block">
                <header class="n-section-title first info_views-area">
                    <h1 class="tit">기본 회원정보</h1>
                    <!-- <button class="n-btn btn-sm btn-default" onclick="openGatePassword('001');">가려진정보 보기</button> -->
                </header>

                <table class="n-table table-row my-info-modify">
                    <colgroup>
                        <col style="width:190px">
                        <col style="width:*">
                        <col style="width:50%">
                    </colgroup>
                    <tbody>
                        <tr>
                        </tr>
                        <tr class="my-info-img" id="profile-image-area">
                            <th scope="row">프로필 사진</th>
                            <td>
                                <div>
                                    <div class="img"
                                        style="background-image: url(https://image.msscdn.net/mfile_s01/_simbols/_basic/d.png)">
                                    </div>
                                </div>
                            </td>
                            <td class="va-b">
                                <button type="button" class="n-btn w100 btn-sm btn-default cert-hidden"
                                    id="change-profile-image-btn">사진 변경</button>
                            </td>
                        </tr>
                        <!--                        사진 수정-->
                        <tr class="my-info-img" style="display: none" id="change-profile-image-area">
                            <th scope="row">사진</th>
                            <td>


                                <div>
                                    <div class="img" id="profile-backGround-image"
                                        style="background-image: url(https://image.msscdn.net/mfile_s01/_simbols/_basic/d.png)">
                                    </div>
                                </div>

                                <p class="txt">회원님을 알릴 수 있는 사진을 등록해 주세요.<br>등록된 사진은 회원님의 게시물이나 댓글들에 사용됩니다.</p>
                                <div class="btn-group">
                                    <label for="profile-image" class="n-btn btn-sm btn-default">사진 선택</label>
                                    <input type="file" id="profile-image" class="n-hidden">
                                    <button type="button" class="n-btn btn-sm btn-default"
                                        id="change-default-image-btn">기본이미지로 변경</button>
                                </div>
                            </td>
                            <td class="va-b">
                                <button type="button" class="n-btn btn-sm btn-lighter"
                                    id="change-profile-image-cancel-btn">취소</button>
                                <button type="button" class="n-btn btn-sm btn-accent"
                                    id="change-profile-image-finish-btn">완료</button>
                            </td>
                        </tr>

                        <tr id="password-area">
                            <th scope="row">비밀번호</th>
                            <td><strong>********</strong></td>
                            <td>
                                <button type="button" class="n-btn w100 btn-sm btn-default cert-hidden"
                                    id="change-password-btn">비밀번호 변경</button>
                            </td>
                        </tr>
                        <!--비밀번호 변경-->
                        <tr id="change-password-area" style="display: none">
                            <th scope="row">비밀번호</th>
                            <td colspan="2">
                                <div class="my-info-modify">
                                    <div class="my-info-modify">
                                        <input type="hidden" id="encryptPassword">
                                        <input type="hidden" id="encryptNewPassword">
                                        <input type="hidden" id="encryptConfirmPassword">
                                        <div class="input">
                                            <label for="password">현재 비밀번호</label>
                                            <div class="input-password__wrap " id="password_div">
                                                <input type="password" class="n-input" id="password">
                                                <button type="button" class="input-password__button"
                                                    onclick="togglePassword('password', this);">비밀번호 표시</button>
                                            </div>
                                            <span id="password-invalid" class="validate danger"></span>
                                        </div>
                                        <div class="input">
                                            <label for="newPassword">신규 비밀번호</label>
                                            <div class="input-password__wrap " id="newPassword_div">
                                                <input type="password" class="n-input" id="newPassword" maxlength="30">
                                                <button type="button" class="input-password__button"
                                                    onclick="togglePassword('newPassword', this);">비밀번호 표시</button>
                                            </div>
                                            <span id="new-password-invalid" class="validate danger"></span>
                                            <span id="valid-newPassword" class="validate" style="display: none">사용 가능한
                                                비밀번호입니다.</span>
                                        </div>
                                        <div class="input">
                                            <label for="confirmPassword">신규 비밀번호 재 입력</label>
                                            <div class="input-password__wrap " id="confirmPassword_div">
                                                <input type="password" class="n-input" id="confirmPassword"
                                                    maxlength="30">
                                                <button type="button" class="input-password__button"
                                                    onclick="togglePassword('confirmPassword', this);">비밀번호 표시</button>
                                            </div>
                                            <span id="confirm-password-invalid" class="validate danger"></span>
                                            <span id="valid-confirmPassword" class="validate" style="display: none">사용
                                                가능한 비밀번호입니다.</span>
                                        </div>
                                        <div class="btn-group">
                                            <button type="button" class="n-btn btn-sm btn-lighter"
                                                id="change-password-cancel-btn">취소</button>
                                            <button type="button" class="n-btn btn-sm btn-accent disabled"
                                                id="change-password-finish-btn" disabled="">완료</button>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">이름(실명)</th>
                            <td>
                                <strong>이*범</strong>

                                <span class="certify">인증완료</span>

                            </td>
                            <td>
                                <button type="button" id="certNameBtn"
                                    class="n-btn w100 btn-sm btn-default">이름수정</button>
                            </td>
                        </tr>
                        <tr id="nickName-area">
                            <th scope="row">닉네임</th>
                            <td><strong>이노인2</strong></td>


                            <td>
                                <button type="button" class="n-btn w100 btn-sm btn-default cert-hidden"
                                    id="change-nickName-btn">닉네임 변경</button>
                            </td>

                        </tr>

                        <!--닉네임 수정-->
                        <tr id="change-nickName-area" style="display: none">
                            <th scope="row">닉네임</th>
                            <td colspan="2">
                                <div class="my-info-modify my-info-modify--nickname">
                                    <ul class="n-info-txt">
                                        <li class="txt-black">이번달 수정 가능 횟수 <strong>4회</strong><span
                                                class="txt-default">(월 최대 4회까지만 변경 가능합니다.)</span>
                                        </li>
                                        <li>길이는 최대 15자 이내로 작성해주세요.</li>
                                        <li>중복 닉네임 불가합니다.</li>
                                        <li>이모티콘 및 일부 특수문자 사용 불가합니다. &amp;&lt;&gt;()'/"</li>
                                    </ul>
                                    <div class="input">
                                        <input type="text" id="nickName" class="n-input" placeholder="닉네임 입력(최대 15자)"
                                            maxlength="15">
                                        <span id="currentNickName" class="validate">현재 닉네임 : 이노인2</span>
                                        <span id="nicknameValidationMessage" class="validate" hidden=""></span>
                                    </div>
                                    <div class="btn-group">
                                        <button type="button" class="n-btn btn-sm btn-lighter"
                                            id="change-nickName-cancel-btn">취소</button>
                                        <button type="button" class="n-btn btn-sm btn-accent disabled"
                                            id="change-nickName-finish-btn" disabled="">완료</button>
                                    </div>
                                </div>
                            </td>
                        </tr>

                        <tr id="email-area">
                            <th scope="row">이메일</th>
                            <td>
                                <strong id="currentEmail" value="wkd****@*****.com">wkd****@*****.com</strong>
                            </td>
                            <td>
                                <button type="button" class="n-btn w100 btn-sm btn-default cert-hidden"
                                    id="change-email-btn">이메일 변경</button>
                            </td>
                        </tr>
                        <!--이메일 인증-->
                        <tr id="change-email-area" style="display: none">
                            <th scope="row">이메일</th>
                            <td colspan="2">
                                <div class="my-info-modify">
                                    <ul class="n-info-txt">
                                        <li>메일주소 입력 후 인증하기 버튼을 누르시면, 회원님의 이메일로 이메일 인증 번호가 적힌메일이 발송됩니다.</li>
                                        <li>아래에 인증 번호를 입력하시면 인증이 완료됩니다.</li>
                                    </ul>
                                    <div class="input input-btn">
                                        <input type="text" class="n-input" placeholder="이메일 주소 입력" id="email"
                                            maxlength="50">
                                        <button type="button" class="n-btn btn-sm btn-accent disabled"
                                            id="send-authentication-email" disabled="">인증</button>
                                    </div>
                                    <div class="input input-w">
                                        <input type="text" class="n-input disabled" id="email-authTempKey"
                                            placeholder="인증번호 입력">
                                    </div>
                                    <div class="btn-group">
                                        <button type="button" class="n-btn btn-sm btn-lighter"
                                            id="change-email-cancel-btn">취소</button>
                                        <button type="button" class="n-btn btn-sm btn-accent disabled"
                                            id="change-email-finish-btn" disabled="">완료</button>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr id="mobile-area">
                            <th scope="row">휴대전화</th>
                            <td><strong>010-****-6474</strong>
                                <span class="certify">인증완료</span>
                            </td>
                            <td>
                                <button type="button" class="n-btn w100 btn-sm btn-default cert-hidden"
                                    id="change-mobile-btn">휴대전화 변경</button>
                            </td>
                        </tr>
                    </tbody>
                </table>

                <ul class="n-info-txt">
                </ul>
            </section>
            <!-- //기본 회원정보 -->





            <!-- 추가 회원정보 -->
            <section class="n-section-block">
                <header class="n-section-title">
                    <h1 class="tit">추가 회원정보 <span>선택</span></h1>
                </header>

                <table class="n-table table-row">
                    <colgroup>
                        <col style="width:190px">
                        <col style="width:*">
                        <col style="width:50%">
                    </colgroup>
                    <tbody>
                        <tr>
                            <th scope="row">생년월일</th>
                            <td><strong>1996.04.04</strong></td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <th scope="row">성별</th>
                            <td>


                                <div>
                                    <strong>남자</strong>
                                </div>


                            </td>
                            <td></td>
                        </tr>
                        <tr>
                            <th scope="row">키/몸무게</th>
                            <td><strong>168cm / 58kg</strong></td>
                            <td><a href="https://www.musinsa.com/app/mypage/mysize_new"
                                    class="n-btn w100 btn-sm btn-default cert-hidden">마이 사이즈</a></td>
                        </tr>
                        <tr>
                            <th scope="row">환불계좌</th>
                            <td><strong id="refund-account" style="color: rgb(0, 0, 0);">이*범 | ****
                                    ************</strong></td>
                            <td>
                                <button type="button" class="n-btn w100 btn-sm btn-default cert-hidden"
                                    id="refund-account-btn">환불계좌 관리</button>
                            </td>
                        </tr>
                        <tr id="address-area">
                            <th scope="row">배송지</th>
                            <td></td>
                            <td>
                                <a href="https://www.musinsa.com/app/mypage/delivery"
                                    class="n-btn w100 btn-sm btn-default">배송지 관리</a>
                            </td>
                        </tr>
                    </tbody>
                </table>

                <ul class="n-info-txt">
                    <li>생년월일, 성별은 수정이 불가능합니다.</li>
                </ul>
            </section>
            <!-- //추가 회원정보 -->
            <div class="n-section-wrap">
                <section class="n-section-block">
                    <!-- 소셜로그인 연동 -->
                    <!-- <header class="n-section-title">
                            <h1 class="tit">소셜 로그인 연동</h1>
                        </header>
                        <div class="my-info-social">
                            <ul>
                                <li class="n-radio-tab">
                                    <em>카카오 로그인 연동</em>
                                    <input type="radio" name="check0" id="onkakao" value="ON">
                                    <label for="onkakao" class="check-on" data-sns="kakao" data-action="on">ON</label>
                                    <input type="radio" name="check0" id="offkakao" value="OFF">
                                    <label for="offkakao" class="check-off" data-sns="kakao" data-action="off">OFF</label>
                                </li>
                                <li class="n-radio-tab">
                                    <em>Apple 로그인 연동</em>
                                    <input type="radio" name="check1" id="onapple" value="ON">
                                    <label for="onapple" class="check-on" data-sns="apple" data-action="on">ON</label>
                                    <input type="radio" name="check1" id="offapple" value="OFF">
                                    <label for="offapple" class="check-off" data-sns="apple" data-action="off">OFF</label>
                                </li>
                            </ul>
                        </div> -->
                    <!-- 소셜로그인 연동 -->
                    <!-- 수신설정 -->
                    <!-- <header class="n-section-title">
                            <h1 class="tit">수신설정</h1>
                            <div class="util">
                                <button id="change-receive-setting" class="n-btn btn-sm btn-default cert-hidden">변경</button>
                                <div class="btn-group receive-setting-change-area">
                                    <button type="button" class="n-btn btn-sm btn-lighter" id="change-setting-cancel-btn" data-sms="" data-email="" style="display: none;">취소</button>
                                    <button type="button" class="n-btn btn-sm btn-accent" id="change-setting-finish-btn" style="display: none;">완료</button>
                                </div>
                            </div>
                        </header>
    
                        <p class="n-info-txt">쇼핑/이벤트 혜택(마케팅 정보 수신)</p>
                        <div class="n-reception-box" style="padding-top: 20px;">
                            <input type="checkbox" class="n-check" id="receiveSmsToggleBtn" disabled="">
                            <label for="receiveSmsToggleBtn">SMS</label>
                            <input type="checkbox" class="n-check" id="receiveEmailToggleBtn" disabled="">
                            <label for="receiveEmailToggleBtn">E-mail</label>
                        </div>
    
                        <ul class="n-info-txt">
                            <li>공지/구매정보/회원정보수정/CS 알림은 수신설정에 상관없이 발송됩니다.</li>
                        </ul> -->
                    <!-- //수신설정 -->
                </section>
                <!-- 자기소개 -->
                <section class="n-section-block" id="introduce-area">
                    <header class="n-section-title">
                        <h1 class="tit">농가 소개</h1>
                        <div class="util">
                            <button class="n-btn btn-sm btn-default cert-hidden" id="change-introduce-btn">변경</button>
                        </div>
                    </header>

                    <div class="my-info-intro">

                        <div>
                            <p class="n-table-none">
                                <span>등록 된 자기소개가 없습니다.</span>
                            </p>
                        </div>


                    </div>
                </section>
                <!-- 자기소개 수정-->
                <section class="n-section-block" id="change-introduce-area" style="display: none">
                    <header class="n-section-title">
                        <h1 class="tit">자기소개</h1>
                        <div class="util">
                            <button class="n-btn btn-sm btn-lighter" id="change-introduce-cancel-btn">취소</button>
                            <button class="n-btn btn-sm btn-accent" id="change-introduce-finish-btn">완료</button>
                        </div>
                    </header>

                    <div class="my-info-intro form">
                        <div class="input">
                            <textarea class="n-input" placeholder="자기소개 입력" id="introduce-text-area"
                                maxlength="150"></textarea>
                            <div id="counter" class="length"><span id="introduce-current-text-length">0</span> 자 / <span
                                    id="introduce-max-text-length">150</span>자 이내</div>
                        </div>
                    </div>
                </section>
                <!-- //자기소개 -->
            </div>
            <p class="my-info-withdrawal">탈퇴를 원하시면 회원탈퇴 버튼을 눌러주세요 <a href="/member/leave"
                    class="n-btn btn-sm btn-default">회원탈퇴</a></p>
        </section>
    </div>
</template>

<script>
    export default {

    }
</script>

<style>
    .mypage-cont {

        padding: 0;
        float: right;
        font-family: "Apple SD Gothic Neo", "Noto Sans KR", sans-serif;
    }

    .n-section-block {
        padding: 0;
    }

    .n-section-title {
        border-bottom: 3px solid #000000;
        padding-bottom: 14px;
        margin-top: 48px;
        font-family: "Apple SD Gothic Neo", "Noto Sans KR", sans-serif;
        line-height: 1.5;
        font-size: 14px;
        position: relative;
    }

    .n-section-title .tit {
        display: inline-block;
        font-size: 24px;
        font-family: "Musinsa", sans-serif !important;
    }

    .n-table {
        width: 100%;
        font-family: "Apple SD Gothic Neo", "Noto Sans KR", sans-serif;
        line-height: 1.5;
        font-size: 14px;
        border-collapse: collapse;
        table-layout: fixed;
    }

    .n-table.table-row th {
        text-align: left;
        font-weight: normal;
        vertical-align: top;
        width: 20%;
    }

    .n-table.table-row th,
    .n-table.table-row td {
        height: auto;
        padding: 15px 0;
        box-sizing: border-box;
        border-top: 1px solid #f1f1f1;
        border-bottom: none;
        font-size: 14px;
        text-align: left;
    }

    .n-table tr.my-info-img .img {
        display: block;
        width: 80px;
        height: 80px;
        margin: 10px 0 0 -6px;
        /* background: url(/skin/musinsa/images/mypage/bg_user2.png) no-repeat 50% 50%; */
        background-size: cover;
        border-radius: 100%;
        overflow: hidden;
    }

    .mypage-cont .n-table.table-row td {
        vertical-align: inherit;
    }

    .n-table.table-row td.va-b {
        vertical-align: bottom;
    }

    .n-btn.btn-default {
        border: 1px solid #e5e5e5;
        background-color: #ffffff;
        color: #000000;
    }

    .n-btn.btn-sm {
        min-width: 70px;
        height: 32px;
        line-height: 30px;
        padding-top: 0;
        float: right;
        font-family: "Apple SD Gothic Neo", "Noto Sans KR", sans-serif !important;
    }

    .n-table a,
    .n-table button {
        display: inline-block;
        vertical-align: middle;
    }

    .n-table button {
        font-family: inherit;
        display: inline-block;
    }

    .n-btn {
        display: inline-block;
        min-width: 100px;
        height: 40px;
        line-height: 36px;
        color: #ffffff;
        box-sizing: border-box;
        padding: 2px 8px 0 8px;
        font-size: 14px;
        text-align: center;
        cursor: pointer;
        vertical-align: middle;
        -webkit-transition: border 0.2s, background 0.2s ease-in-out;
        -moz-transition: border 0.2s, background 0.2s ease-in-out;
        -o-transition: border 0.2s, background 0.2s ease-in-out;
        transition: border 0.2s, background 0.2s ease-in-out;
    }
</style>