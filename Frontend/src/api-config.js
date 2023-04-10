let backendHost;

const hostname = window && window.location && window.location.hostname;
if (hostname === "localhost") {
    // URI를 잘못 입력하면 주소를 찾을 수 없게 되어서 fetch를 못하게 되고 터지게 됨
    // URI를 잘못 입력했을 때 CORS 에러를 뱉기도 함
    backendHost = "http://localhost:8080"
} else {
    backendHost = "https://api.sweethedge.com";
}

export const API_BASE_URL = `${backendHost}`;