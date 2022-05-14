import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { firstValueFrom } from 'rxjs';
import { CreateCommentRequest } from '../contracts/requests';
import { Comment } from '../contracts/models';

@Injectable({
  providedIn: 'root',
})
export class CommentService {
  constructor(private httpClient: HttpClient) {}

  public async createComment(
    userId: number,
    trailId: number,
    request: CreateCommentRequest
  ): Promise<Comment> {
    return await firstValueFrom(
      this.httpClient.post<Comment>(
        `http://localhost:7070/comment/${userId}/${trailId}`,
        request
      )
    );
  }

  public async updateComment(
    userId: number,
    commentId: number,
    request: CreateCommentRequest
  ): Promise<Comment> {
    return await firstValueFrom(
      this.httpClient.put<Comment>(
        `http://localhost:7070/comment/${userId}/${commentId}`,
        request
      )
    );
  }

  public async deleteComment(
    userId: number,
    commentId: number
  ): Promise<Comment> {
    return await firstValueFrom(
      this.httpClient.delete<Comment>(
        `http://localhost:7070/comment/${userId}/${commentId}`
      )
    );
  }
}
