import axios from "axios";
import { BASE_URL } from "./ApiBaseUrl";

export const getCategoryById = async (id) => {
    const url = `${BASE_URL}/api/category/${id}`

    const httpOptions = {
        headers: {
            Accept: 'application/json'
        },
        validateStatus: status => true
    }

    return await axios.get(url, httpOptions)
}

export const getAllCategories = async () => {
    const url = `${BASE_URL}/api/category`;

    const httpOptions = {
        headers: {
            Accept: 'application/json'
        },
        validateStatus: status => true
    }

    return await axios.get(url, httpOptions)
}