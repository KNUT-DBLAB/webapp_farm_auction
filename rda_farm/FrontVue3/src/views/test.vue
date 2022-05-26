<template>
    <div>
        <div class="main_nav_t_div">
            <nav class="main_t_nav">
                <ul class="main_t_nav_list">
                    <li class="nav__btn">
                        <div class="nav__notification-dot"></div>
                        <a class="nav__link"><i class="fas fa-bars fa-2x" aria-hidden="true"></i>
                        </a>
                    </li>


                    <li class="main_m_li_list">
                        <a class="nav_m_link" href="workout.html">
                            <h4 class="user-component__title">회원 정보</h4><i class=" fa-2x" aria-hidden="true" image
                                src="../image/123.jpg"></i>
                        </a>
                    </li>

                    <li class="nav__btn">
                        <a class="nav__link" onclick="goBack()"><i class="fas fa-chevron-left fa-2x"
                                aria-hidden="true"></i>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        
        <!-- 기본 회원정보 -->
        <header class="n-section-title first info_views-area">
            <h1 class="tit">기본 회원정보</h1>
            <!-- <button class="n-btn btn-sm btn-default" onclick="openGatePassword('001');">가려진정보 보기</button> -->
        </header>


        <!-- 프로필 -->
        <table class="n-table table-row my-info-modify">
            <colgroup>
                <col style="width:25%">
                <col style="width:40%">
                <col style="width:35%">
            </colgroup>
            <tbody>
                <tr>
                    <th scope="row"><strong>이메일</strong></th>
                    <td>
                        이메일
                    </td>
                    <!-- <td>
                        <button type="button" class="n-btn w100 btn-sm btn-default">이메일 수정</button>
                    </td> -->
                </tr>
                <tr>
                    <th scope="row"><strong>비밀번호</strong></th>
                    <td>
                        비밀번호
                    </td>
                    <td>
                        <button type="button" class="n-btn w100 btn-sm btn-default">비밀번호 수정</button>
                    </td>
                </tr>
                <tr>
                    <th scope="row"><strong>휴대폰번호</strong></th>
                    <td>
                        휴대폰번호
                    </td>
                    <td>
                        <button type="button" class="n-btn w100 btn-sm btn-default">휴대폰번호 수정</button>
                    </td>
                </tr>
            </tbody>
        </table>

        <!-- 농가 프로필 -->
        <header class="n-section-title first info_views-area">
            <h1 class="tit">농가 회원정보</h1>
            <!-- <button class="n-btn btn-sm btn-default" onclick="openGatePassword('001');">가려진정보 보기</button> -->
        </header>
        <table class="n-table table-row my-info-modify">
            <colgroup>
                <col style="width:25%">
                <col style="width:40%">
                <col style="width:35%">
            </colgroup>
            <tbody>
                <tr>
                </tr>
                <tr class="my-info-img" id="profile-image-area">
                    <th scope="row"><strong>프로필 사진</strong></th>
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

                <tr>
                    <th scope="row"><strong>농가 이름</strong></th>
                    <td>
                        농가 이름
                    </td>
                    <td>
                        <button type="button" class="n-btn w100 btn-sm btn-default">농가 이름 수정</button>
                    </td>
                </tr>
                <tr>
                    <th scope="row"><strong>농가 전화번호</strong></th>
                    <td>
                        농가 전화번호
                    </td>
                    <td>
                        <button type="button" class="n-btn w100 btn-sm btn-default">농가 전화번호 수정</button>
                    </td>
                </tr>
                <tr>
                    <th scope="row"><strong>사업자 이름</strong></th>
                    <td>
                        사업자 이름
                    </td>
                    <!-- <td>
                        <button type="button" class="n-btn w100 btn-sm btn-default">사업자 이름 수정</button>
                    </td> -->
                </tr>
                <tr>
                    <th scope="row"><strong>사업자 등록번호</strong></th>
                    <td>
                        사업자 등록번호
                    </td>
                    <!-- <td>
                        <button type="button" class="n-btn w100 btn-sm btn-default">사업자 등록번호 수정</button>
                    </td> -->
                </tr>
                <tr>
                    <th scope="row"><strong>우편번호</strong></th>
                    <td>
                        우편번호
                    </td>
                    <td>
                        <button type="button" class="n-btn w100 btn-sm btn-default">우편번호 수정</button>
                    </td>
                </tr>
                <tr>
                    <th scope="row"><strong>농가 주소</strong></th>
                    <td>
                        농가 주소
                    </td>
                    <td>
                        <button type="button" class="n-btn w100 btn-sm btn-default">농가 주소 수정</button>
                    </td>
                </tr>
                <tr>
                    <th scope="row"><strong>입급 은행</strong></th>
                    <td>
                        입급 은행
                    </td>
                    <td>
                        <button type="button" class="n-btn w100 btn-sm btn-default">계좌 수정</button>
                    </td>
                </tr>
                <tr>
                    <th scope="row"><strong>입금자 명</strong></th>
                    <td>
                        입금자 명
                    </td>
                    <!-- <td>
                        <button type="button" class="n-btn w100 btn-sm btn-default">입금자 명 수정</button>
                    </td> -->
                </tr>
                <tr>
                    <th scope="row"><strong>계좌 번호</strong></th>
                    <td>
                        계좌 번호
                    </td>
                    <!-- <td>
                        <button type="button" class="n-btn w100 btn-sm btn-default">계좌 번호 수정</button>
                    </td> -->
                </tr>
                <tr>
                    <th scope="row"><strong>농가 URL</strong></th>
                    <td>
                        농가 URL
                    </td>
                    <td>
                        <button type="button" class="n-btn w100 btn-sm btn-default">농가 이동</button>
                    </td>
                </tr>
            </tbody>
        </table>

        <!-- 농가 소개 -->
        <header class="n-section-title first info_views-area">
            <h1 class="tit">농가명</h1>
            <!-- <button class="n-btn btn-sm btn-default" onclick="openGatePassword('001');">가려진정보 보기</button> -->
        </header>

        <table class="n-table table-row my-info-modify">
            <colgroup>
                <col style="width:25%">
                <col style="width:40%">
                <col style="width:35%">
            </colgroup>
            <tbody>
                <tr>
                    <th scope="row"><strong>농가 설명</strong></th>
                    <td>
                        농가 설명
                    </td>
                    <td>
                        <button type="button" class="n-btn w100 btn-sm btn-default">농가 설명 수정</button>
                    </td>
                </tr>
                <tr>
                    <th scope="row"><strong>주요 농작물</strong></th>
                    <td>
                        주요 농작물
                    </td>
                    <td>
                        <button type="button" class="n-btn w100 btn-sm btn-default">주요 농작물 수정</button>
                    </td>
                </tr>
                <tr>
                    <th scope="row"><strong>농가 사진</strong></th>
                    <td>
                        농가 사진
                    </td>
                    <td>
                        <button type="button" class="n-btn w100 btn-sm btn-default">농가 사진 수정</button>
                    </td>
                </tr>
            </tbody>
            <button @click="getlocal()">dd{{key.bbb}}</button>
        </table>
    </div>
    <bottom-nav />
</template>

<script>
import bottomNav from '@/components/bottomNav.vue';
import { values } from 'sockjs-client/lib/transport-list';

export default {
    components: { bottomNav },
    data() {
        return 
    },

    methods: {
    getlocal (auction) {
        console.log(auction);
        localStorage.setItem(key, values);
        localStorage.getItem(key);
        },
    }
}
</script>

<style>

</style>