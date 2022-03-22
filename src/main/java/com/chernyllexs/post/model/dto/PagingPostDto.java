package com.chernyllexs.post.model.dto;

import java.util.List;

public class PagingPostDto {
    private int numberOfPages;
    private int currentPage;
    private List<PostDto> posts;

    public PagingPostDto() {
    }

    public PagingPostDto(int numberOfPages, int currentPage, List<PostDto> posts) {
        this.numberOfPages = numberOfPages;
        this.currentPage = currentPage;
        this.posts = posts;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public PagingPostDto setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
        return this;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public PagingPostDto setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        return this;
    }

    public List<PostDto> getPosts() {
        return posts;
    }

    public PagingPostDto setPosts(List<PostDto> posts) {
        this.posts = posts;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PagingPostDto that = (PagingPostDto) o;

        if (getNumberOfPages() != that.getNumberOfPages()) return false;
        if (getCurrentPage() != that.getCurrentPage()) return false;
        return getPosts() != null ? getPosts().equals(that.getPosts()) : that.getPosts() == null;
    }

    @Override
    public int hashCode() {
        int result = getNumberOfPages();
        result = 31 * result + getCurrentPage();
        result = 31 * result + (getPosts() != null ? getPosts().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PagingPostDto{" +
                "numberOfPages=" + numberOfPages +
                ", currentPage=" + currentPage +
                ", posts=" + posts +
                '}';
    }
}
